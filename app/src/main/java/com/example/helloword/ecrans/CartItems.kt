package com.example.helloword.ecrans

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.helloword.comman.Cart
import com.example.helloword.model.Product

@Composable
fun CartItems(produits : List<Product>,controller : NavHostController){
    val set = produits.toSet()
    val listp = set.toList()
    /*val setdesproduits : MutableSet<Product> = mutableSetOf()

    for(elm in produits){
        setdesproduits.add(elm)
    }

    val listp : MutableList<Product> = mutableListOf()
    for(elm in setdesproduits){
        listp.add(elm)
    }*/

    LazyColumn {
        items(listp) { product ->
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
                        Button(onClick = {Cart.supprimeProduit(product.id)}) { Text("supprimer")}
                    }
                }
            }
        }
    }
}