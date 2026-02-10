package com.example.helloword.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.helloword.comman.Cart
object Nombre{
    var nbrProduit = mutableStateOf(0)
    fun ajouterProduit(){
        nbrProduit.value ++
    }
}
@Composable
fun ComponentRacine(){
    var nbr by remember { mutableStateOf(Nombre.nbrProduit.value) }
    val add = { nbr++ }

    Text("hello i am compoent racine nbr = ${Nombre.nbrProduit.value}",modifier=Modifier.padding(top=40.dp))
    Column(modifier = Modifier.padding(50.dp)) {
        Button(onClick = { Nombre.ajouterProduit() }){Text("change")}
        ComponentA(nbr, { Nombre.ajouterProduit() } )
        Spacer(Modifier.height(50.dp))
        ComponentB(nbr, { Nombre.ajouterProduit() })
    }

}