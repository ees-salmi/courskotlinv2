package com.example.helloword.viewmodels

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.helloword.interfaces.SimpleApi
import com.example.helloword.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
// exerice change le logique métier pour afficher la liste des produits fakeapi
class NumberViewLodel : ViewModel(){
    //model
    private var _number =  MutableStateFlow(1) //géeer l etat interne
    val number : StateFlow<Int> = _number
    fun augmenter(){
        _number.value  += 1
    }
}


@Composable
fun AfficherNumber(numberViewModel: NumberViewLodel = viewModel()) {
    // collectAsStateWithLifecycle est préférable pour économiser les ressources
    val number by numberViewModel.number.collectAsState()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()) {
        Text("le numero est = $number")
        Button(onClick = {numberViewModel.augmenter()}) { Text("augmenter") }
     }
}
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
