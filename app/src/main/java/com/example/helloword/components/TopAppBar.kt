package com.example.helloword.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helloword.comman.Cart
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myTopBar(){ TopAppBar(title = {},
    colors = TopAppBarDefaults.topAppBarColors(
        containerColor = Color(255, 140, 0,100),
        titleContentColor = Color.Black

    ),
    actions = {
        Row {
            CartBadge(Cart.nbrProduit.value)
            //space
            IconButton(onClick = {  }) {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "Déconnexion"
                )
            }
        }

    })
}
@Composable
fun myBar(){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.background(color = Color.Yellow).fillMaxWidth().height(100.dp)
    ){
        Text("Commandes", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Spacer(Modifier.width(20.dp))
        Text("Commandes")
        Spacer(Modifier.width(20.dp))
        Text("Commandes")
    }
}