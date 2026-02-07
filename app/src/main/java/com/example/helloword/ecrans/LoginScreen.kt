package com.example.helloword.ecrans

import androidx.compose.foundation.Image
import com.example.helloword.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.helloword.components.MonText
import com.example.helloword.components.MyButton
import com.example.helloword.components.MyTextField
import com.example.helloword.model.User


@Composable
fun LoginScreen(modifier: Modifier, controller : NavHostController){
    // variables d etat
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember {mutableStateOf(false)}
    val user1 = User(username,password)
    var results by remember { mutableStateOf("") }
    //results = username
    val  traitementAfaire = { if(username.length > 10 && password.length > 10) {controller.navigate("loginmodification/$username/$password")} else {error = true} }

       Column(
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally,
           modifier = modifier.padding(10.dp)
       ) {
           Image(painter = painterResource(R.drawable.profile),"image")
           MonText()
           //Spacer(Modifier.height(200.dp))
           Text("Sign In", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.Blue)
           MyTextField(text = "username", value = username,onChangeValue = {username = it}, isError = error, modifier = Modifier.fillMaxWidth())
           Spacer(Modifier.height(10.dp))
           MyTextField(text = "password", value = password,onChangeValue = {password = it},isError = error, modifier = Modifier.fillMaxWidth())

           Spacer(Modifier.height(10.dp))
           MyButton("valider", onClick = traitementAfaire )
           Spacer(Modifier.height(10.dp))
           MyButton("display data", onClick = { controller.navigate("displayProducts") } )
           Spacer(Modifier.height(10.dp))
           Text(results)
       }


}


