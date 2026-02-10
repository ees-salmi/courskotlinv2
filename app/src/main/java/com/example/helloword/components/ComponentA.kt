package com.example.helloword.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ComponentA(nbr: Int, f: () -> Unit){
    //var nbr = 0
    Text("hello i am compoent A nbr = ${Nombre.nbrProduit.value}")
    Button(onClick = f){Text("augmener nbr")}
}