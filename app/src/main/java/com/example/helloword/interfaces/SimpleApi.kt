package com.example.helloword.interfaces

import com.example.helloword.model.Pc
import com.example.helloword.model.Product
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

// web services, le protocole REST , méthodes HTTP
interface SimpleApi {
    //post méthode HTTP pour envoyer des données avec post a l'end point "pcportable"
    @POST("pcportable")
    suspend fun addProduct(): Pc
    // méthode HHTP pour récupérer les données
    @GET("getpcportable")
    suspend fun getPcs(): List<Pc>
    @GET("products")
    suspend fun getProducts(): List<Product>
    @GET("products/{id}")
    suspend fun getProductById(@Path("id")  id : Int): Product?
}

