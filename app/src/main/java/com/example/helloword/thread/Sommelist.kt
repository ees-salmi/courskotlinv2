package com.example.helloword.thread

fun main() {
    val grosseListe = (1..1_000_000).toList()
    val milieu = grosseListe.size / 2

    var sommePartie1 = 0L
    var sommePartie2 = 0L


   val t1 = Thread{
       sommePartie1 = grosseListe.subList(0,milieu).sumOf { it.toLong() }
   }

    val t2 = Thread{
        sommePartie2 = grosseListe.subList(milieu,grosseListe.size).sumOf { it.toLong() }
    }


    t1.join()
    t2.join()

    val total = sommePartie1 + sommePartie2
    println("Somme totale calculée en parallèle : $total")
}
