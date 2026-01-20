package com.example.helloword.ecrans

import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.viewinterop.AndroidView
import com.example.helloword.components.*
import com.example.helloword.R
@Composable
fun FormulaireXML(modifier : Modifier = Modifier) {
        var name by remember { mutableStateOf("") }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth()
        ) {
            Image(painterResource(id = R.drawable.fillform), contentDescription = "formulaire")
            MyText("Create An Account")
            AndroidView(
                factory = { context ->

                    LayoutInflater.from(context).inflate(R.layout.card_image, null, false)
                },
                modifier = Modifier.fillMaxWidth(),
                update = { view ->
                        view.findViewById<TextView>(R.id.textView2).text = name

                }
            )

            MyTextField("name", name, { name = it }, modifier = Modifier.fillMaxWidth())
        }


}