package com.example.helloword.ecrans

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.helloword.model.Product
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.helloword.interfaces.SimpleApi
import retrofit2.http.GET
import retrofit2.http.Path



@Composable
fun SimpleProductScreen(controller: NavHostController) {

    var products by remember { mutableStateOf<List<Product>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    // Chargement des données au démarrage
    LaunchedEffect(Unit) {
        try {
            // Builder() c'est un design pattern : méthode de création des objets
            val retrofit = Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val api = retrofit.create(SimpleApi::class.java)
            products = api.getProducts()
        } catch (e: Exception) {
            errorMessage = "Erreur : ${e.localizedMessage}"
            println(errorMessage)
        } finally { // finally pour executer une instruction dans tous les cas
            isLoading = false
        }
    }

    // Interface utilisateur
    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else if (errorMessage != null) {
            Text(text = errorMessage!!, color = MaterialTheme.colorScheme.error, modifier = Modifier.align(Alignment.Center))
        } else {
            LazyColumn {
                items(products) { product ->
                    Card(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                        elevation = CardDefaults.cardElevation(4.dp),
                        onClick = {controller.navigate("displayProduct/${product.id}")}
                    ) {
                        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                            AsyncImage(
                                model = product.image,
                                contentDescription = null,
                                modifier = Modifier.size(100.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text(text = product.title, style = MaterialTheme.typography.titleMedium, maxLines = 1)
                                Text(text = "${product.price} dh", style = MaterialTheme.typography.bodyMedium)
                                Text(text = "${product.description} dh", style = MaterialTheme.typography.bodySmall)

                            }
                        }
                    }
                }
            }
        }
    }
}
