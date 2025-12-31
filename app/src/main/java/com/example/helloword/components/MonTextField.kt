package com.example.helloword.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun MyTextField(text:String,value:String,onChangeValue : (String) -> Unit, modifier : Modifier = Modifier ) {
    OutlinedTextField(
        value = value,
        onValueChange = onChangeValue,
        label = {Text(text)},
        placeholder = {Text("donner votre $text")},
        modifier = modifier
    )
}