package com.example.helloword.ecrans

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.helloword.components.ProductItem
import com.example.helloword.viewmodels.viewModels

@Composable
fun UserListScreen(viewModel: viewModels) {
    LaunchedEffect(Unit) {
        viewModel.chargerDonnees()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (viewModel.isLoading) {

            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp)
            ) {
                item {
                    Row(Modifier.background(MaterialTheme.colorScheme.primaryContainer).padding(8.dp)) {
                        TableCell(text = "Name", weight = 0.2f, isHeader = true)
                        TableCell(text = "Email", weight = 0.2f, isHeader = true)
                        TableCell(text = "Role", weight = 0.2f, isHeader = true)
                        TableCell(text = "Action", weight = 0.2f, isHeader = true)
                    }
                }
                items(viewModel.listeProducts) { product ->
                    Row(Modifier.fillMaxWidth().padding(8.dp)) {
                        TableCell(text = product.title, weight = 0.2f)
                        TableCell(text = product.price.toString(), weight = 0.2f)
                        TableCell(text = product.description, weight = 0.2f)
                    }
                }
            }
        }
    }
}
