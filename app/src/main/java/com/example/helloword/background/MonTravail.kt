package com.example.helloword.background

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log
import kotlin.concurrent.thread

// job scheduling
class MonTravail : JobService() {
    override fun onStartJob(params: JobParameters?): Boolean {
        var nobreprodui = 200
        var  addtodatabase = nobreprodui
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
       Log.d("data ","les doennées envoyés")
        return true
    }

}

fun main() {
    val tableau = IntArray(100) { it + 1 } // Tableau de 1 à 100 (Somme attendue : 5050)
    val milieu = tableau.size / 2

    var somme1 = 0
    var somme2 = 0

    // Thread 1 : Calcule la première moitié (0 à 49)
    val t1 = thread {
        for (i in 0 until milieu) {
            somme1 += tableau[i]
        }
    }

    // Thread 2 : Calcule la seconde moitié (50 à 99)
    val t2 = thread {
        for (i in milieu until tableau.size) {
            somme2 += tableau[i]
        }
    }

    // On attend que les deux threads finissent avant de faire le total
    t1.join()
    t2.join()

    val total = somme1 + somme2
    println("Somme totale : $total")
}
