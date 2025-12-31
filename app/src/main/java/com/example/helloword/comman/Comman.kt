package com.example.helloword.comman

import androidx.compose.ui.text.toLowerCase

class Comman {

    fun effacerEspace(str : String):String{
        return str.toLowerCase().trim()
    }
}