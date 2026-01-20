package com.example.helloword.ecrans

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.helloword.components.myTopBar
import com.example.helloword.model.Pc

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val list : ArrayList<Pc> = arrayListOf(Pc(2.0,"hp"),Pc(4.5,"dell"),Pc(1.0,"mac"),Pc(2.0,"pc"))
    Scaffold(
        topBar = { myTopBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = {  }) {
                Icon(Icons.Default.Add, contentDescription = "Ajouter")
            }
        },
        bottomBar = {
            BottomAppBar {  }
        }
    ) { innerPadding ->
        LoginScreen(Modifier.padding(innerPadding))

        }
    }
/*
val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "accueil"
        ) {
            composable("accueil") {
                EcranAccueil(
                    onAllerAuxDetails = { navController.navigate("dashboard") },
                    modifier = Modifier.padding(innerPadding)
                )
            }
            composable("dashboard") {
                EcranDashboard(
                    onRetourAllerVersAcceuil = { navController.navigate("accueil") },
                    modifier = Modifier.padding(innerPadding)
                )
            }
            composable("details") {
                EcranDetails(
                    onRetour = { navController.popBackStack() },
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
 */
@Composable
fun EcranAccueil(onAllerAuxDetails: () -> Unit,modifier : Modifier) {
    Column(modifier = modifier) {
        Text("Bienvenue sur l'écran d'accueil")
        Button(onClick = onAllerAuxDetails) {
            Text("Aller vers Détails")
        }
    }
}
@Composable
fun EcranDetails(onRetour: () -> Unit,modifier : Modifier) {
    Column(modifier = modifier) {
        Text("Voici les détails")
        Button(onClick = onRetour) {
            Text("Revenir en arrière")
        }
    }
}

@Composable
fun EcranDashboard(onRetourAllerVersAcceuil: () -> Unit,modifier : Modifier) {
    Column(modifier = modifier) {
        Text("Voici le dashboard")
        Button(onClick = onRetourAllerVersAcceuil) {
            Text("Revenir en accueil")
        }
    }
}