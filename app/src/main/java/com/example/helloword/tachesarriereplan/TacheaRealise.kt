package com.example.helloword.tachesarriereplan

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class TacheaRealise : JobService() {
    override fun onStartJob(params: JobParameters?): Boolean {
        //synchronisé entre les données de l application et le serveur du bd
        Log.d("debut de la tache","la tache a commcé")
        Thread{
            Thread.sleep(1000)
            jobFinished(params,false)
        }.start()
        Log.d("fin de la tache","la tache est terminé")

        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d("tache arrete","la tache est arrete")
        return true
    }

}