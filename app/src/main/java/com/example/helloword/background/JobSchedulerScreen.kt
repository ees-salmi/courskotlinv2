package com.example.helloword.background

import android.annotation.SuppressLint
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

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

        val scheduler = context.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        val resultCode = scheduler.schedule(info)

        if (resultCode == JobScheduler.RESULT_SUCCESS) {
            Log.d("JobScheduler", "Job planifié avec succès !")
        }
    }, modifier = Modifier.padding(40.dp)) {
        Text("Planifier la tâche")
    }
}
