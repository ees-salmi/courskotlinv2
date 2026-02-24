package com.example.helloword.model

class Pole(var numero : Int, var listPc : List<Pc>) {

    fun getNumeroPole():Int{
        return numero
    }

    fun getPrmierPc(): Pc {
        return listPc.get(0)
    }
    fun getMaxList(list : List<Int>):Int{
        var max = list[0]
        max = list.max()
        return max
    }
}