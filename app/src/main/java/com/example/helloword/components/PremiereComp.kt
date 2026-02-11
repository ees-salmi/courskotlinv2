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
fun PremiereComp(nombreStg : NombreStg){

    Column {
        Text("le nombre dans premiere coms est ${nombreStg.nombre.value}")
        Button(onClick = {nombreStg.modifierNbr()}){Text("augmenter")}
    }

}