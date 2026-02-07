package com.example.helloword.interfaces

import com.example.helloword.model.Product
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {
    @GET("products")
    suspend fun getProducts(): List<Product>
    @GET("products/{id}")
    suspend fun getProductById(@Path("id")  id : Int): Product?
}

