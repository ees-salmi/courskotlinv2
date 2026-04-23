package com.example.helloword.data

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity(tableName = "compteBancaire")
class Compte{
     var idClient = 0
     var numeroCompte = ""
     var solde = 0.0
}
@Entity(tableName = "tableClient")
class Client{
    var idClient = 0
    var nom = ""
}

@Dao
interface CompteDAO{

    @Insert
    suspend fun ajouterCompte(cpt : Compte)

    @Query("select solde from compteBancaire where idClient = :id ")
     fun getSoldebyId(id : Int) : Double

    @Query("select solde from compteBancaire")
    suspend fun getSolde() : List<Double>

    // a revoir Delete

}

@Database(entities = [Compte::class,Client::class],version = 0)
abstract class CompteBancaireDatabase : RoomDatabase()