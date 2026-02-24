package com.example.helloword.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import com.example.helloword.R
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.TextStyle

@Composable
fun Quantity(quantity : String){

    var quantity by remember { mutableStateOf(quantity) }
    Row {
        IconButton(onClick = {quantity = (quantity.toInt() - 1).toString()}) {
            Icon(
                Icons.Rounded.Add, contentDescription = "remove"
            )
        }
        OutlinedTextField(value = quantity, onValueChange = {quantity = it}, modifier = Modifier.size(40.dp), textStyle = androidx.compose.ui.text.TextStyle(fontSize = 8.sp)
        )
        IconButton(onClick = {quantity = (quantity.toInt() + 1).toString()}) {
            Icon(
                Icons.Rounded.Add, contentDescription = "add"
            )
        }
    }
}