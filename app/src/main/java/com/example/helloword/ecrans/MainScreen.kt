package com.example.helloword.ecrans

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.helloword.components.myTopBar
import com.example.helloword.model.Pc

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val list : ArrayList<Pc> = arrayListOf(Pc(2.0,"hp"),Pc(4.5,"dell"),Pc(1.0,"mac"),Pc(2.0,"pc"))
    Scaffold(
        topBar = { myTopBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = {  }) {
                Icon(Icons.Default.Add, contentDescription = "Ajouter")
            }
        },
        bottomBar = {
            BottomAppBar {  }
        }
    ) { innerpadding ->
        LoginScreen(Modifier.fillMaxWidth().padding(innerpadding))
    }
}