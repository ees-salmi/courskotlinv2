package com.example.helloword.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MonText() {
    Box(modifier = Modifier.background(Color.Yellow)) {
        Text(
            "Texte décalé",
            modifier = Modifier.align(BiasAlignment(horizontalBias = -0.5f, verticalBias = 1f))
        )
    }


}