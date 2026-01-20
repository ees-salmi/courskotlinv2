package com.example.helloword.model

import com.example.helloword.prin
class SoldeNegtafiException(val m : String):Exception(m)
class CompteBancaire(val numero : Int, var solde : Double){
    init {
        var a = 2
        var b = 0
        var division = a/b
    }
}
class Bureaux(val longueur: Double, val largeur : Double){
    companion object {
        val long = 20
        fun afficherLong(){
            print(long)
        }
    }
    override fun toString(): String {
        return "bureau est : "+largeur+" "+longueur
    }
}
class Salle(val numero:Int,val surface : Double, val listbureau : MutableList<Bureaux> ){
    fun afficherListBureau(){
        for(elm in listbureau){
            println(elm)
        }
        //listbureau.forEach { br -> println(br) }
    }
}

fun main(){
    val list : MutableList<Bureaux> = mutableListOf()
    //val bur = Bureaux(100.5,20.0)
    Bureaux.afficherLong()


    list.add(Bureaux(100.5,20.0))
    list.add(Bureaux(200.5,25.0))
    list.add(Bureaux(50.0,2.2))
    // trouver les bureaux dont la longueur est sup à 20 et largeur est pair
    val nlist = list.filter { it.longueur > 80.0 }[0]
    println(nlist)

    val salle1 = Salle(8,100.0,list)
    /* salle1.afficherListBureau()
     try {
         var compte1 = CompteBancaire(1,-600.0)
     } catch (ex : Exception){
         println(ex.message)
     }*/


    print("continuite")
}