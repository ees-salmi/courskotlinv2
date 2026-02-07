package com.example.helloword.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextRange

@Composable
fun CartBadge(nombreArticles : Int){
    BadgedBox(
        badge = { Badge(){Text("$nombreArticles")} }
    ) {
        Icon(
            imageVector = Icons.Filled.ShoppingCart,
            "panier"
        )
    }
}