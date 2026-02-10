package com.example.helloword.components

import androidx.compose.foundation.layout.Column
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
import com.example.helloword.NombreStg

@Composable
fun DeuxiemeComp(NombreStg: NombreStg) {
    //var nombre by remember { mutableStateOf(0) }
    Column(Modifier.padding(top=40.dp)) {Text("le nombre dans la deuxieme com est = ${NombreStg.nombre.value}")
    Button(onClick = {NombreStg.modifierNbr()}) { Text("Incrementer")}}
}