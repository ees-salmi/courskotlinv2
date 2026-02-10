package com.example.helloword.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CartBadge(nombreArticles: Int){

    BadgedBox(
        modifier = Modifier.padding(top=15.dp),
        badge = { Badge(){Text("$nombreArticles")} }
    ) {
        Icon(
            imageVector = Icons.Filled.ShoppingCart,
            "panier"
        )
    }
}