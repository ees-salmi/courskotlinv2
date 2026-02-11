package com.example.helloword.interfaces

import com.example.helloword.model.Pc
import com.example.helloword.model.Product
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SimpleApi {
    @POST("pcportable")
    suspend fun addProduct(): List<Pc>
    @GET("pcportable")
    suspend fun getPcs(): List<Pc>
    @GET("products")
    suspend fun getProducts(): List<Product>
    @GET("products/{id}")
    suspend fun getProductById(@Path("id")  id : Int): Product?
}

