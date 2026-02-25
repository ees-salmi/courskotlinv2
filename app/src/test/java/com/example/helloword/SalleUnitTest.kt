package com.example.helloword

import com.example.helloword.model.Classe
import com.example.helloword.model.Pc
import org.junit.Assert.assertEquals
import org.junit.Test

class SalleUnitTest {

    @Test
    fun test_get_numero_salle(){
        val pc1 = Pc(2000.0,"HP")
        val pc2 = Pc(4000.0,"DELL")
        var list = arrayListOf(pc1,pc2)
        /*var list2 : ArrayList<Pc> = arrayListOf()
        list2.add(pc1)
        list2.add(pc2)*/
        var c1 = Classe(6,"salle6",list)
        assertEquals(6,c1.getNumeroSalle())
    }
    @Test
    fun test_get_nom_salle(){
        val pc1 = Pc(2000.0,"HP")
        val pc2 = Pc(4000.0,"DELL")
        var list = arrayListOf(pc1,pc2)
        /*var list2 : ArrayList<Pc> = arrayListOf()
        list2.add(pc1)
        list2.add(pc2)*/
        var c1 = Classe(6,"salle6",list)
        assertEquals("salle6",c1.getNomSalle())
    }

    @Test
    fun test_get_first_element(){
        val pc1 = Pc(2000.0,"HP")
        val pc2 = Pc(4000.0,"DELL")
        var list = arrayListOf(pc1,pc2)

        var c1 = Classe(6,"salle6",list)

        assertEquals(pc1,c1.getFirstElement())
    }
    @Test
    fun test_get_last_element(){
        val pc1 = Pc(2000.0,"HP")
        val pc2 = Pc(4000.0,"DELL")
        var list = arrayListOf(pc1,pc2)

        var c1 = Classe(6,"salle6",list)

        assertEquals(pc2,c1.getLastElement())
    }
    // test espresso
    @Test
    fun test_get_last_elementv2(){
        var list : ArrayList<Pc> = arrayListOf()
        val pc1 = Pc(2000.0,"HP")
        var c1 = Classe(6,"salle6",list)

        assertEquals(null,c1.getLastElement())
    }

}