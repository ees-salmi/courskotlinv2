package com.example.helloword.ecrans

import android.annotation.SuppressLint
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.helloword.background.MonTravail
import com.example.helloword.comman.Cart
import com.example.helloword.components.Quantity
@SuppressLint("MissingPermission")
@Composable
fun JobSchedulerScreen() {
    val context = LocalContext.current

    Button(onClick =  {
        val componentName = ComponentName(context, MonTravail::class.java)

        val info = JobInfo.Builder(123, componentName) // Uniquement en Wi-Fi
            .setPersisted(true) // Garder le job même après redémarrage du tel
            .setPeriodic(15*60*1000) // setMinimumLatency(1000) // Toutes les 1 minutes (minimum imposé)
            .build()
            //.setMinimumLatency(1000)

        val scheduler = context.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        val resultCode = scheduler.schedule(info)

        if (resultCode == JobScheduler.RESULT_SUCCESS) {
            Log.d("JobScheduler", "Job planifié avec succès !")
        }
    }, modifier = Modifier.padding(40.dp)) {
        Text("Planifier la tâche")
    }
}
@Composable
fun BackgroundProducts(controller : NavHostController) {
    JobSchedulerScreen()
    LazyColumn {
        items(Cart.listBackground) { product ->
            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                onClick = {controller.navigate("displayProduct/${product.id}")}
            ) {
                Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(
                        model = product.image,
                        contentDescription = null,
                        modifier = Modifier.size(100.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(text = product.title, style = MaterialTheme.typography.titleMedium, maxLines = 1)
                        Text(text = "${product.price} dh", style = MaterialTheme.typography.bodyMedium)
                        Text(text = "${product.description} dh", style = MaterialTheme.typography.bodySmall)
                        Text(text = "quantity = ${Cart.listProducts.get(product)} ", style = MaterialTheme.typography.bodySmall)
                        Row(){Quantity(Cart.listProducts.get(product).toString())
                            Button(onClick = {Cart.supprimeProduitfromMap(product)}) { Text("supprimer")}}
                    }
                }
            }
        }
    }
}