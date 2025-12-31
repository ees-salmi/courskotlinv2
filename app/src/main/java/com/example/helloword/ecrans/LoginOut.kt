package com.example.helloword.ecrans

import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginOut() {
    // État pour stocker la saisie des utilisateurs
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var resultMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Formulaire d'inscription", style = MaterialTheme.typography.headlineMedium)

        // Premier TextField
        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("Prénom") },
            modifier = Modifier.fillMaxWidth()
        )

        // Deuxième TextField
        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Nom") },
            modifier = Modifier.fillMaxWidth()
        )

        // Bouton de validation
        Button(
            onClick = {
                resultMessage = if (firstName.isNotBlank() && lastName.isNotBlank()) {
                    "Bienvenue, $firstName $lastName !"
                } else {
                    "Veuillez remplir tous les champs."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Valider")
        }

        // Affichage du résultat
        if (resultMessage.isNotEmpty()) {
            Text(
                text = resultMessage,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
