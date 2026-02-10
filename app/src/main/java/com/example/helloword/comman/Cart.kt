package com.example.helloword.comman

import androidx.compose.runtime.mutableStateOf


object Cart{
    var nbrProduit = mutableStateOf(0)
    fun ajouterProduit(){
        nbrProduit.value ++
    }
}

