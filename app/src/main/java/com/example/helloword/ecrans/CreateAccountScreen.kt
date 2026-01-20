package com.example.helloword.ecrans


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.helloword.components.*
import com.example.helloword.R

@Composable
fun CreateAccount(modifier : Modifier) {
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var resultat by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Image(painterResource(R.drawable.fillform),"formulaire")
        MyText("Create An Account")
        MyTextField("name",name,{name = it},modifier = Modifier.fillMaxWidth())
    }
    }
