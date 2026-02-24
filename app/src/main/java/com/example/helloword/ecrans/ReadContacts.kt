package com.example.helloword.ecrans

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat

fun readContacts(context: Context) {
    val contentResolver = context.contentResolver

    // Projection : définir les colonnes que l'on souhaite récupérer
    val projection = arrayOf(
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER
    )

    // Requête sur la table des numéros de téléphone
    val cursor = contentResolver.query(
        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
        projection,
        null,
        null,
        null
    )

    cursor?.use {
        val nameIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
        val numberIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)

        while (it.moveToNext()) {
            val name = it.getString(nameIndex)
            val number = it.getString(numberIndex)
            // Pour cet exemple, on affiche dans les Logs
            Log.d("Contacts", "Nom: $name, Tel: $number")
        }
    } ?: Log.e("Contacts", "Impossible d'accéder au curseur ou aucun contact trouvé")
}


@Composable
fun ReadContacts() {
    val context = LocalContext.current

    // 1. Créer le launcher pour demander la permission
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // Succès : Vous pouvez maintenant lire les contacts
            Toast.makeText(context, "Permission accordée !", Toast.LENGTH_SHORT).show()
        } else {
            // Échec : L'utilisateur a refusé
            Toast.makeText(context, "Permission refusée", Toast.LENGTH_SHORT).show()
        }
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
    Button(modifier = Modifier.padding(20.dp),onClick = {
        // 2. Vérifier si la permission est déjà accordée avant de demander
        val permissionCheck = ContextCompat.checkSelfPermission(
            context, Manifest.permission.READ_CONTACTS
        )

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            // Déjà autorisé : Appeler votre fonction de lecture
            readContacts(context)
        } else {
            // Non autorisé : Lancer la demande système
            permissionLauncher.launch(Manifest.permission.READ_CONTACTS)
        }
    }) {
        Text("Accéder aux contacts")
    }}
}
