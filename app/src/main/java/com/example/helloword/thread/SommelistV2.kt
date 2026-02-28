package com.example.helloword.thread

import kotlin.concurrent.thread

fun main(){

    var grandlist = (1..1_000_000).toList()
    var somme = 0
    var somme1 = 0
    var somme2 = 0
    var somme3 = 0
    var tier1 = grandlist.size / 3

    var thread1 = thread {
        somme1 = grandlist.subList(0,tier1).sumOf { it }
    }

    var thread2 = thread {
        somme2 = grandlist.subList(tier1, 2 * tier1).sumOf { it }
    }
    var thread3 = thread {
        somme3 = grandlist.subList(2*tier1,grandlist.size).sumOf { it }
    }

    thread1.join()
    thread2.join()
    thread3.join()

    somme = somme1 + somme2 + somme3
    println("la somme avec les threads est = $somme")


}