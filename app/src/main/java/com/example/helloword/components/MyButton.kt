package com.example.helloword.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyButton(text: String = "", onClick : ()-> Unit = {}){
    Button(onClick = onClick, modifier = Modifier.fillMaxWidth()) { MyTextButton() }
}

@Composable
fun MyTextButton(){
    Text("valider")
}