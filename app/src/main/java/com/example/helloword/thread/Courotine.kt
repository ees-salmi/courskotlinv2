package com.example.helloword.thread

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helloword.interfaces.SimpleApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun getProducts(): String {
    delay(1000)
    return "products OK"
}
class viewModels(private val api: SimpleApi) : ViewModel() {
    val data  = viewModelScope.launch { getProducts() }
}
