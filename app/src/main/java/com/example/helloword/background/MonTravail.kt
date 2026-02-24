package com.example.helloword.background

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log
import com.example.helloword.model.Product

// job scheduling
class MonTravail : JobService() {

    override fun onStartJob(params: JobParameters?): Boolean {
        Log.d("job commencé","le job a commencé")
        var product = Product(1,"produi1",2.2,"produit a partir d'un job","electronique","image1")
        //Cart.listBackground.add(product)
        //Cart.listBackground.add(product)
        Thread {
            Thread.sleep(5000)
            jobFinished(params, false)
        }.start()
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d("JobScheduler", "Le Job a été annulé par le système")
        return true
    }

}