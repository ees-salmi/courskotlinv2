package com.example.helloword.ecrans

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.helloword.interfaces.SimpleApi
import com.example.helloword.model.Product
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.helloword.comman.Cart
@Composable
fun ProductScreen(controller : NavHostController, id : Int) {

    val addToCart = {}
    var nombreDesArticles by remember { mutableStateOf(0) }
    // variables static
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var product by remember { mutableStateOf<Product?>(Product()) }
    var p = product
    LaunchedEffect(Unit) {
        try {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val api = retrofit.create(SimpleApi::class.java)
            product = api.getProductById(id)
            p = product
        } catch (e: Exception) {
            errorMessage = "Erreur : ${e.localizedMessage}"
            println(errorMessage)
        } finally {
            isLoading = false
        }
    }
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = { controller.navigate("displayProducts") }
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = product?.image,
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = product!!.title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1
                )
                Text(text = "${product!!.price} dh", style = MaterialTheme.typography.bodyMedium)
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.End) {
                    Button(onClick = {Cart.ajouterProduit(p)}){Text("ajouter au panier")}
                }

            }
        }
    }
}