package com.example.helloword.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helloword.interfaces.SimpleApi
import com.example.helloword.model.Product
import com.example.helloword.model.User
import kotlinx.coroutines.launch

class viewModels(private val api: SimpleApi) : ViewModel() {
    //Survie à la rotation viewModelScope Séparation des préoccupations
    var listeProducts by mutableStateOf<List<Product>>(emptyList())
    var isLoading by mutableStateOf(false)

    fun chargerDonnees() {
        viewModelScope.launch {
            isLoading = true
            try {
                val resultat = api.getProducts()
                listeProducts = resultat
            } catch (e: Exception) {
                listeProducts = listOf(Product(1,"hello",23.3,"hello","bonjour","image"))
                println("Erreur réseau : ${e.message}")
                android.util.Log.e("${e.message}", "Erreur réseau", e)
            } finally {
                isLoading = false
            }
        }
    }
}
