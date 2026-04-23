package com.example.helloword

//import com.example.helloword.comman.DrawRect
//import com.example.helloword.components.MonText
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.mutableStateOf
import kotlinx.serialization.Serializable

//singleton

object NombreStg{
    var nombre = mutableStateOf(0)
 fun modifierNbr() {
     nombre.value++
 }
}
class MainActivity : ComponentActivity() {



    @Serializable
    data class RouteEcran3(val username: String)

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            
        }
}








