package com.example.helloword

import android.R


class Personne(val age:Int,val nom:String, val prenom:String){

    fun ajouter(): Personne{
        return this
    }

    fun supperson( age : Int):Personne{
        return this
    }

}

fun main(){
    val p = Personne(12,"AMine")
    p.ajouter().supperson(12).ajouter()
}