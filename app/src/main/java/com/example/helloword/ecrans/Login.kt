package com.example.helloword.ecrans

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.helloword.components.MyButton
import com.example.helloword.components.MyTextField
import com.example.helloword.model.User


@Composable
fun LoginScreen(modifier: Modifier){

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val user1 = User(username,password)
    var results by remember { mutableStateOf("") }
    val  traitementAfaire = {  results = username }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(20.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()){

            MyTextField("username", username,{username = it}, Modifier.weight(1f))
            Spacer(Modifier.width(10.dp))
            MyTextField("password", password,{password = it},Modifier.weight(1f))
        }
        Spacer(Modifier.height(10.dp))
        MyButton("valider", onClick = traitementAfaire )
        Spacer(Modifier.height(10.dp))
        Text(results)
    }
}


