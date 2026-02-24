package com.example.helloword

import com.example.helloword.model.Pc
import com.example.helloword.model.Pole
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun soustraction_isCorrect() {
        assertEquals(4, 8 - 4)
    }

    @Test
    fun affichage_premier_element(){
        val pc1 = Pc(2000.0,"HP")
        val pc2 = Pc(3000.0,"DELL")
        val listpc : ArrayList<Pc> = arrayListOf()
        listpc.add(pc1)
        listpc.add(pc2)
        val pole1 = Pole(1,listOf(pc1,pc2))
        val n = pole1.getNumeroPole()
        assertEquals(1,n)
        assertEquals(pc1,pole1.getPrmierPc())
    }

}