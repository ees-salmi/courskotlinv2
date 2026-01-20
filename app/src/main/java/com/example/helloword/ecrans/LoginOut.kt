package com.example.helloword.ecrans

import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.helloword.R

@Composable
fun LoginOut(modifier: Modifier = Modifier) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var resultat by remember { mutableStateOf("") }
    var isVisible by remember { mutableStateOf(false) }
    val traitement = {  isVisible = !isVisible}
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Formulaire d'inscription", style = MaterialTheme.typography.headlineMedium)


        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Préusername") },
            modifier = Modifier.fillMaxWidth()
        )


        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("password") },
            visualTransformation = if(isVisible)  VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = { IconButton(onClick = traitement, modifier = Modifier.size(30.dp) ) {val image = if(!isVisible) R.drawable.show else R.drawable.hide
                Icon(painterResource(image),"afficher") } },
            modifier = Modifier.fillMaxWidth()
        )

        // Bouton de validation
        Button(
            onClick = {
                        isVisible = !isVisible
                resultat = if(username.isEmpty() && password.isEmpty()) "donner votre username et preusername" else "bonjour $username $password"
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Valider")
        }

        // Affichage du résultat
        if (isVisible) {
            Text(
                text = resultat,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
