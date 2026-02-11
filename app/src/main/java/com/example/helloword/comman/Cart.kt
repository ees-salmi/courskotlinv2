package com.example.helloword.comman

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.example.helloword.model.Product


object Cart{
    var list = mutableStateListOf<Product>()
    var nbrProduit = mutableStateOf(0)
    fun ajouterProduit(){
        nbrProduit.value ++
    }
    fun ajouterProduit(product: Product?){
        if( product == null) return
        else list.add(product)
    }

}

