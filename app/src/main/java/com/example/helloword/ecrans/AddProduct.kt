package com.example.helloword.ecrans

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import com.example.helloword.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.helloword.components.MonText
import com.example.helloword.components.MyButton
import com.example.helloword.components.MyTextField
import com.example.helloword.model.User


@Composable
fun AddProduct(modifier: Modifier = Modifier) {
    // Variables d'état existantes
    var error by remember { mutableStateOf(false) }

    // --- NOUVEL ÉTAT POUR L'IMAGE ---
    var imageUri by remember { mutableStateOf<Uri?>(null) }


    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(10.dp).fillMaxSize()
    ) {
        MonText()

        Text("Ajouter Produit", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.Blue)

        Spacer(Modifier.height(15.dp))

        // --- ZONE IMAGE ---
        Card(
            modifier = Modifier
                .size(120.dp)
                .clickable { launcher.launch("image/*") }, // Ouvre la galerie au clic
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                if (imageUri != null) {
                    // Affiche l'image sélectionnée
                    AsyncImage(
                        model = imageUri,
                        contentDescription = "Image produit",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    // Placeholder si aucune image
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Default.AddCircle, contentDescription = null, tint = Color.Gray)
                        Text("Photo", fontSize = 12.sp, color = Color.Gray)
                    }
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        Spacer(Modifier.height(10.dp))

        Spacer(Modifier.height(20.dp))
        MyButton("Valider le produit", onClick = {
            // Ici, vous pouvez envoyer username, password et imageUri à votre DB
        })
    }
}



