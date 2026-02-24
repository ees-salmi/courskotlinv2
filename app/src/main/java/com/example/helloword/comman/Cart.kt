package com.example.helloword.comman

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import com.example.helloword.model.Product


object Cart{
    var list = mutableStateListOf<Product>()
    var listBackground = mutableStateListOf<Product>()
    var listProducts = mutableStateMapOf<Product,Int>()
    var productMap : HashMap<Product,Int> = hashMapOf()
    var nbrProduit = mutableStateOf(0)
    fun ajouterProduit(){
        nbrProduit.value ++
    }
    fun ajouterProduit(product: Product?){
        var qte = 0
        if( product == null) return
        else {
            list.add(product)
            if(listProducts.get(product) != null) {
                listProducts.get(product)?.let { qte = it + 1 }
                listProducts.put(product, qte)
            }
            else {
                listProducts.put(product, 1)
            }
        }
    }
    fun supprimeProduit(id : Int){
        list.removeIf { it.id == id }
    }
    fun supprimeProduitfromMap(product : Product){
        listProducts.remove(product)
    }

    fun convertListtoMap(){
        var qte = 0
        for(elm in list){
            for (elm2 in list){
                if(elm == elm2){
                    qte++
                }
            }
            productMap.put(elm,qte)
        }
    }



}

