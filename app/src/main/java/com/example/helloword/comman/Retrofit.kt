package com.example.helloword.comman

import com.example.helloword.interfaces.SimpleApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofit = Retrofit.Builder()
    .baseUrl("https://fakestoreapi.com")
    .addConverterFactory(GsonConverterFactory.create()) // Convertit le JSON en objet
    .build()

val api = retrofit.create(SimpleApi::class.java)
