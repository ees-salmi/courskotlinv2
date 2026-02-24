package com.example.helloword.tachesarriereplan

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun JobSchedulerScreen() {

    val context  = LocalContext.current
    val configuration = {
        val component = ComponentName(context, TacheaRealise::class.java)
        val information = JobInfo.Builder(234,component)
            .setRequiresCharging(true)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED) // remplaçer par 2
            .setPeriodic(30*60*1000)
            .build()

        val scheduler = context.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        val resultCode = scheduler.schedule(information)

        if (resultCode == JobScheduler.RESULT_SUCCESS) {
            Log.d("scheduler", "tache est planifié")
        }

    }

    Button(onClick = configuration) { Text("demarer mon job") }
}