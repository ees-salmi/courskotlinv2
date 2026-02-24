package com.example.helloword.ecrans

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.example.helloword.comman.Cart
import com.example.helloword.components.myTopBar
import com.example.helloword.model.Pc

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val controller = rememberNavController()

    val list: ArrayList<Pc> =
        arrayListOf(Pc(2.0, "hp"), Pc(4.5, "dell"), Pc(1.0, "mac"), Pc(2.0, "pc"))
    Scaffold(
        topBar = { myTopBar(controller) },
        floatingActionButton = {
            FloatingActionButton(onClick = { controller.navigate("backgroundProducts")}) {
                Icon(Icons.Default.Add, contentDescription = "Ajouter")
            }
        },
        bottomBar = {
            BottomAppBar { }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            var user = "username"
            NavHost(
                navController = controller,
                startDestination = "login"
            ) {
                composable("backgroundProducts") {
                    BackgroundProducts(controller)
                }
                composable("displayProducts") {
                    SimpleProductScreen(controller)
                }
                composable("displayProduct/{id}") { backStackEntry ->
                    val id = backStackEntry.arguments?.getString("id")!!.toInt()
                    ProductScreen(controller, id)
                }
                composable("card") {
                    myCardImage(controller)
                }
                composable("cartitems") {
                    CartItems(Cart.list ,controller)
                }
                composable("login") {
                    LoginScreen(
                        modifier = Modifier,
                        controller = controller
                    )
                }
                composable("loginmodification/{username}/{password}") { backStackEntry ->
                    val username = backStackEntry.arguments?.getString("username") ?: "valeur"
                    val password = backStackEntry.arguments?.getString("password") ?: "valeur"
                    LoginModification(
                        modifier = Modifier,
                        controller = controller,
                        username,
                        password
                    )
                }

                composable(
                    "createaccount",
                    enterTransition = {
                        slideIntoContainer(
                            towards = AnimatedContentTransitionScope.SlideDirection.Up,
                            animationSpec = tween(700)
                        )
                    }
                ) {

                    CreateAcount(modifier = Modifier, controller = controller)
                }

            }
        }
    }
}
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