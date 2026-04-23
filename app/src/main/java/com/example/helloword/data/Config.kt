package com.example.helloword.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

import androidx.lifecycle.viewModelScope
import androidx.room.*
import kotlinx.coroutines.flow.* // Importe StateFlow, SharingStarted, stateIn
import kotlinx.coroutines.launch

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val titre : String,
    val prix : Double
)

@Dao
interface ProductDao {
    @Insert
    suspend fun insertProduct(product: ProductEntity)

    @Query("SELECT * FROM products")
    fun getAllProducts(): Flow<List<ProductEntity>>
}

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}

class ProductViewModel(private val dao: ProductDao) : ViewModel() {
    // Transformation du Flow en StateFlow
    val products: StateFlow<List<ProductEntity>> = dao.getAllProducts().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun addProduct(titre: String, prix: Double) {
        viewModelScope.launch {
            dao.insertProduct(ProductEntity(titre = titre, prix = prix))
        }
    }
}





