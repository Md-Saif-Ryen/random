package com.example.bookflight.ui.theme.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.bookflight.ui.theme.black
import com.example.bookflight.ui.theme.currentText

@Composable
fun text(modifier: Modifier = Modifier) {
    Text(
        text = "Create an Acccount",
        fontSize = 20.sp,
        color = currentText,

    )

}