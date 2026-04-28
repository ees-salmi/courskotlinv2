package com.example.helloword.dao

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val price: Double
)



@Dao
interface ProductDao {
    @Insert
    suspend fun insert(product: Product)

    @Query("SELECT * FROM products")
    suspend fun getAll(): List<Product>
    @Query("SELECT * FROM products where id = :id AND title = :tit")
    suspend fun getProductById(id : Int, tit : String): Product
}


@Database(entities = [Product::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    // utiliser insert pour inserer un produit depuis le main
}