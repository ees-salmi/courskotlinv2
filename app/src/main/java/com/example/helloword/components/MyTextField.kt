package com.example.helloword.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation


@Composable
fun MyTextField(text:String,value:String,onChangeValue : (String) -> Unit, modifier : Modifier = Modifier ) {
    var isVisible by remember { mutableStateOf(false) }
    val traitement = {isVisible = !isVisible}
    OutlinedTextField(
        value = value,
        onValueChange = onChangeValue,
        label = {Text(text)},
        visualTransformation = if(isVisible) VisualTransformation.None else PasswordVisualTransformation() ,
        placeholder = {Text("donner votre $text")},
        modifier = modifier,
        trailingIcon = { IconButton(onClick = {traitement})  { Icon(Icons.Rounded.Edit, "eye") }}
    )
}