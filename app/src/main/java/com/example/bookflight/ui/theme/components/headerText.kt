package com.example.bookflight.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookflight.ui.theme.currentText

@Composable
@Preview
fun HeaderText(text1 :String ="Login", subHeader : String = "Welcome back to the app") {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "Login", style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.SemiBold))
            Text(text = "Welcome back to the app", fontSize = 18.sp, fontWeight = FontWeight.Normal)
        }
    }
}