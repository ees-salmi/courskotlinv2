package com.example.helloword.ecrans

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.google.accompanist.permissions.*

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocationPermissionScreen() {
    // État pour gérer plusieurs permissions (Fine et Coarse)
    val locationPermissionState = rememberMultiplePermissionsState(
        listOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )
    )

    if (locationPermissionState.allPermissionsGranted) {
        Text("Accès à la localisation accordé !")
    } else {
        Column {
            val textToShow = if (locationPermissionState.shouldShowRationale) {
                "La localisation est nécessaire pour afficher les magasins proches."
            } else {
                "L'autorisation de localisation est requise."
            }
            Text(textToShow)
            Button(onClick = { locationPermissionState.launchMultiplePermissionRequest() }) {
                Text("Autoriser la localisation")
            }
        }
    }
}
