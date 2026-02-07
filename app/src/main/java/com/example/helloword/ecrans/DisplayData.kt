package com.example.helloword.ecrans

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
// Patient(numeroDossier(entier), nom(String), age(int),tel(String))
data class User(val name: String, val email: String, val role: String)

@Composable
fun DisplayData(users: List<User> = listOf<User>(User("salmi","salmi@gmail.com","teacher"),User("salmi","salmi@gmail.com","teacher"),User("salmi","salmi@gmail.com","teacher"),User("salmi","salmi@gmail.com","teacher"),User("salmi","salmi@gmail.com","teacher"),User("salmi","salmi@gmail.com","teacher"),User("salmi","salmi@gmail.com","teacher"),User("salmi","salmi@gmail.com","teacher"),User("salmi","salmi@gmail.com","teacher"),User("salmi","salmi@gmail.com","teacher"),User("salmi","salmi@gmail.com","teacher"),User("salmi","salmi@gmail.com","teacher"),User("salmi","salmi@gmail.com","teacher"),User("salmi","salmi@gmail.com","teacher"),User("salmi","salmi@gmail.com","teacher"))) {

    val nameWeight = 0.3f
    val emailWeight = 0.4f
    val roleWeight = 0.3f

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        item {
            Row(Modifier.background(MaterialTheme.colorScheme.primaryContainer).padding(8.dp)) {
                TableCell(text = "Name", weight = nameWeight, isHeader = true)
                TableCell(text = "Email", weight = emailWeight, isHeader = true)
                TableCell(text = "Role", weight = roleWeight, isHeader = true)
                TableCell(text = "Action", weight = roleWeight, isHeader = true)
            }
        }


        items(users) { user ->
            Row(Modifier.fillMaxWidth().padding(8.dp)) {
                TableCell(text = user.name, weight = nameWeight)
                TableCell(text = user.email, weight = emailWeight)
                TableCell(text = user.role, weight = roleWeight)
            }
            HorizontalDivider(thickness = 0.5.dp)
        }
    }
    FloatingActionButton(onClick = {}) { Text("ajoutr utilisateur")}
}

@Composable
fun RowScope.TableCell(text: String, weight: Float, isHeader: Boolean = false) {
    Text(
        text = text,
        modifier = Modifier.weight(weight).padding(4.dp),
        style = if (isHeader) MaterialTheme.typography.titleSmall else MaterialTheme.typography.bodyMedium,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}
