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
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_header)
        var note = 0.0
        var rb1 = findViewById<RadioButton>(R.id.radioButton4)
        var affichage = findViewById<TextView>(R.id.affichgecheckbutton)







        var mygroup = findViewById<RadioGroup>(R.id.radioGroup)
        mygroup.setOnCheckedChangeListener { groupe, checkedid ->
            when(checkedid) {
                R.id.radioButton4 -> {note+=2}
                R.id.radioButton5 -> {affichage.text = "reponse fausee"}
                R.id.radioButton6 -> {affichage.text = "reponse fausee"}

            }
        }









       /* val list = listOf("yassine","ilyass","ibrahim","yamine")
        var adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            list
        )

        val auto = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        auto.setAdapter(adapter)
        auto.threshold = 3*/






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
    }

}
