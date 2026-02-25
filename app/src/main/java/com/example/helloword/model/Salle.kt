package com.example.helloword.model

class Classe(var numero:Int,var nom : String,var listpc : ArrayList<Pc> ) {

    fun getNumeroSalle() : Int {
        return this.numero
    }

    fun getNomSalle() : String {
        return nom
    }

    fun getFirstElement() : Pc {
        return listpc[0]
    }

    fun getLastElement() : Pc? {
        if(listpc.size != 0){
            return listpc[listpc.size - 1]
        }
        else
            return null
    }


}