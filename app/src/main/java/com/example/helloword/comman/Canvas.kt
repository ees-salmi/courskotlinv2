package com.example.helloword.comman

import android.R
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import java.nio.file.WatchEvent

@Composable
fun DrawEmoji(){
    Canvas(modifier = Modifier.fillMaxSize()) {

       val cx = 540f
       val cy = 1200f
       drawCircle(
           center = Offset(cx,cy),
           radius = 200f,
           brush = SolidColor(Color.Yellow)
       )
        drawCircle(
            center = Offset(cx-60f,cy-60),
            radius = 20f,
            brush = SolidColor(Color.Black)
        )
        drawCircle(
            center = Offset(cx+60f,cy-60),
            radius = 20f,
            brush = SolidColor(Color.Black)
        )
        drawLine(
            start = Offset(cx-30,cy+90),
            end = Offset(cx+30,cy+90),
            brush = SolidColor(Color.Black)
        )















           /* drawArc(
                color = Color.LightGray,
                startAngle = 0f,
                sweepAngle = -90f,
                useCenter = false,
                style = Stroke(width = 20f)
            )

            drawArc(
                color = Color.Blue,
                startAngle = -90f, // Commence en haut
                sweepAngle = 270f,
                useCenter = false,
                style = Stroke(width = 20f, cap = StrokeCap.Round) // Bords arrondis
            )

        val path = Path().apply {
            moveTo(100f, 100f)
            lineTo(200f, 100f)
            lineTo(400f, 400f)
            lineTo(50f, 400f)
            close()
        }
        drawPath(path = path, color = Color.Green)


        drawLine(
            brush = SolidColor(Color.Magenta),
            start = Offset(50f, 2000f),
            end = Offset(1000f, 2000f),
            strokeWidth = 8f,
            cap = StrokeCap.Round
        )
        drawLine(
            brush = Brush.linearGradient(
                colors = listOf(Color.Red, Color.Blue)
            ),
            start = Offset(1000f, 2000f),
            end = Offset(1000f, 200f),
            strokeWidth = 8f,
            cap = StrokeCap.Round
        )
        drawLine(
            brush = SolidColor(Color.Magenta),
            start = Offset(50f, 2000f),
            end = Offset(1000f, 2000f),
            strokeWidth = 8f,
            cap = StrokeCap.Round
        )
            drawCircle(
                color = Color.Red,
                radius = 100f,
                center = Offset(50f,50f) // Optional: defaults to canvas center
            )


*/
    }
}