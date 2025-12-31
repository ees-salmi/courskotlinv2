package com.example.helloword

import android.os.Bundle
import android.text.Editable
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.compose.runtime.setValue
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helloword.components.myBar
import com.example.helloword.components.myTopBar
import com.example.helloword.ecrans.CardAvecImage
import com.example.helloword.ecrans.MainScreen
import com.example.helloword.ecrans.LoginOut
import com.example.helloword.ecrans.LoginScreen
import com.example.helloword.model.Pc


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{MainScreen()}
    }

}
// 9 present 2512
@Composable
fun myText(text : String){
    Text(
        text = text,
        color = Color.Green,
        fontSize = 28.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(all = 20.dp)
            .background(Color.DarkGray)
            .padding(20.dp)
    )
}
@Composable
fun text(){Text("clicker ici")}
@Composable
fun myButton(){
    FloatingActionButton(
        onClick = lambda,
        content = { Text("clicker ici") },
        containerColor = Color.DarkGray,
        modifier = Modifier.padding(30.dp)
        //.size(80.dp,30.dp)
    )
}

@Composable
fun myButtonText(nom:String,age:Int){
    Text(
        text="clcik here",
        color = Color.Green,
        fontSize = 18.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Thin,
        modifier = Modifier
            .padding(all = 20.dp)
            .background(Color.DarkGray)
            .padding(20.dp)
    )
}
val lambda = { -> print("hello")}
fun prin(){
    print("bonjour")
}

@Composable
fun MyInput(text:String,value:String,onChangeValue : (String) -> Unit ) {

    TextField(
        value = value,
        onValueChange = onChangeValue,
        label = { Text("Tapez votre $text") },
        placeholder = {Text("donner votre $text")}
    )

}

@Composable
fun myInput(input:String, onChangeValue: (String) -> Unit){
    TextField(
        value = input,
        onValueChange = onChangeValue,
        label = { Text("nom") },
        placeholder = {Text("donner votre nom")},
        modifier= Modifier
            .padding(5.dp)
            .fillMaxWidth()
    )
}
@Composable
fun myBox(modifier: Modifier = Modifier){
    Box(
        modifier = Modifier.padding(20.dp)

    ){

    }
}
@Composable
fun MyBoxes(modifier: Modifier){
    Row(modifier = Modifier.padding(10.dp)){
        Box(modifier = Modifier
            .background(Color.Red)
            .border(3.dp, Color.Blue)
            .weight(1f)
            .height(200.dp) )
        Box(modifier = Modifier
            .background(Color.Cyan)
            .border(3.dp, Color.Blue)
            .weight(2f)
            .height(200.dp))
        Box(modifier = Modifier
            .background(Color.Blue)
            .border(3.dp, Color.Blue)
            .weight(3f)
            .height(200.dp))
    }
}
@Composable
fun myColumn(modifier : Modifier = Modifier){
    var noms  = ""
    var nom by remember { mutableStateOf("") }
    var prenom by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        MyInput("nom",nom,{ nom = it })
        MyInput("prenom", prenom, {prenom = it})
        MyInput("age", age, {age = it})
        myButtonText(nom,age.toInt())
    }
}
@Composable
fun MonTitre(){
    Row() {
        Text("Commandes",
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Serif,
            fontSize = 24.sp
        )

    }

}
@Composable
fun MonIcon(){
    Icon(Icons.Default.Menu, contentDescription = "menu")
}



        /* code pour radio button
        var note = 0.0
        var rb1 = findViewById<RadioButton>(R.id.radioButton4)
        var affichage = findViewById<TextView>(R.id.affichgecheckbutton)







        var mygroup = findViewById<RadioGroup>(R.id.radioGroup)
        mygroup.setOnCheckedChangeListener { groupe, checkedid ->
            when(checkedid) {
                R.id.radioButton4 -> {note+=2 }
                R.id.radioButton5 -> {affichage.text = "reponse fausee"}
                R.id.radioButton6 -> {affichage.text = "reponse fausee"}

            }
        }*/



       /* val list = listOf("yassine","ilyass","ibrahim","yamine")
        var adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            list
        )

        val auto = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        auto.setAdapter(adapter)
        auto.threshold = 2*/






        /*var valeur1:Int? = null
        var valeur2:Int? = null
        var d = ""

        setContentView(R.layout.activity_calculatrice)
        val btn1 = findViewById<Button>(R.id.btn_1)
        val btn2 = findViewById<Button>(R.id.btn_2)
        val btn3 = findViewById<Button>(R.id.btn_3)
        val btn4 = findViewById<Button>(R.id.btn_4)
        val btn5 = findViewById<Button>(R.id.btn_5)
        val btn6 = findViewById<Button>(R.id.btn_6)
        val btn7 = findViewById<Button>(R.id.btn_7)
        val btn8 = findViewById<Button>(R.id.btn_8)
        val btn9 = findViewById<Button>(R.id.btn_9)

        val edit = findViewById<EditText>(R.id.edit1)

        btn1.setOnClickListener {

            if(valeur2 != null){
                d = "$valeur1 + $valeur2"
                edit.setText(d)
            }
            else {
                valeur1 = 1
                var valeur2t = valeur2?:""
                d = "$valeur1 + $valeur2t"
                edit.setText(d)

            }
        }
        btn2.setOnClickListener {edit.setText("2")
            valeur1 = 2

        }
        btn3.setOnClickListener {edit.setText("3")
            valeur1 = 3
        }
        btn4.setOnClickListener {edit.setText("4")
            valeur1 = 4
        }
        btn5.setOnClickListener {edit.setText("5")
            valeur1 = 5
        }
        btn6.setOnClickListener {edit.setText("6")
            valeur1 = 6
        }
        btn7.setOnClickListener {edit.setText("7")
            valeur1 = 7
        }
        btn8.setOnClickListener {edit.setText("8")
            valeur1 = 8
        }
        btn9.setOnClickListener {edit.setText("9")
            valeur1 = 9
        }
        val btnplus = findViewById<Button>(R.id.btn_plus)
        val btnmoins = findViewById<Button>(R.id.btn_minus)
        val btndivision = findViewById<Button>(R.id.btn_1)
        btnplus.setOnClickListener {
            d = "$valeur1 + "
            edit.setText(d)
        }
        btnmoins.setOnClickListener {
            val text : String = "$valeur1 - "
            edit.setText(text)
        }
        if( valeur1 != null){
        btn1.setOnClickListener {edit.setText("1")
            valeur2 = 1
            d  = d + "$valeur2"
            edit.setText(d)
        }
        btn2.setOnClickListener {edit.setText("2")
            valeur2 = 2
            d  = d + "$valeur2"
            edit.setText(d)
        }
        btn3.setOnClickListener {edit.setText("3")
            valeur2 = 3
            val text : String = "$valeur1 + $valeur2"
            edit.setText(text)
        }
        btn4.setOnClickListener {edit.setText("4")
            valeur2 = 4
            val text : String = "$valeur1 + $valeur2"
            edit.setText(text)
        }
        btn5.setOnClickListener {edit.setText("5")
            valeur2 = 5
            val text : String = "$valeur1 + $valeur2"
            edit.setText(text)
        }
        btn6.setOnClickListener {edit.setText("6")
            valeur2 = 6
            val text : String = "$valeur1 + $valeur2"
            edit.setText(text)
        }
        btn7.setOnClickListener {edit.setText("7")
            valeur2 = 7
            val text : String = "$valeur1 + $valeur2"
            edit.setText(text)
        }
        btn8.setOnClickListener {edit.setText("8")
            valeur2 = 8
            val text : String = "$valeur1 + $valeur2"
            edit.setText(text)
        }
        btn9.setOnClickListener {edit.setText("9")
            valeur2 = 9
            val text : String = "$valeur1 + $valeur2"
            edit.setText(text)
        }}
*/








        /*val myListView: ListView = findViewById(R.id.myListView)

        val data = arrayListOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)

        myListView.adapter = adapter

        myListView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as String
            Toast.makeText(this, "Clicked: $selectedItem", Toast.LENGTH_SHORT).show()
        }*/

        /*val btn1 = findViewById<Button>(R.id.btn_1)
        val btn2 = findViewById<Button>(R.id.btn_2)
        btn1.setOnClickListener { btn2.text=2.toString() }*/

