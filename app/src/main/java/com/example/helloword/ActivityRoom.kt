package com.example.helloword

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.helloword.dao.Product
import com.example.helloword.dao.ProductDao
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    private lateinit var adapter: ArrayAdapter<String>
    private val productNames = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.roomtest)
        val title = findViewById<EditText>(R.id.roomtitle).text.toString()
        val prix  =  findViewById<EditText>(R.id.roomprix).text.toString().toDouble()

        lifecycleScope.launch {

            val produit = Product(1,title,prix)
            ProductDao.insert(produit)


        }
        }

        }


}