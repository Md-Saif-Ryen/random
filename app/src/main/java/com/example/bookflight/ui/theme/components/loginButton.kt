package com.example.bookflight.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookflight.R
import com.example.bookflight.ui.theme.black
import com.example.bookflight.ui.theme.currentText
import kotlinx.coroutines.Job

@Composable
fun ButtonLogin(buttonText:String,onClick: () -> Unit) {
    Box(modifier = Modifier.background(currentText, shape = RoundedCornerShape(50))) {
        Button(
            onClick = { onClick() }, modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = currentText)
        ) {
            Text(text = buttonText, fontSize = 18.sp, color = Color.White)
        }
    }
}


@Composable
fun ButtonGoogle(function: () -> Unit) {
    Box(
        modifier = Modifier
            .background(
                Color(0xFFE4E7EB),
                shape = RoundedCornerShape(10.dp)
            )
            .fillMaxWidth()
            .height(50.dp)
            .clickable { function() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.google),
                modifier = Modifier
                    .size(24.dp)
                    .weight(1f),
                contentDescription = null
            )
            Text(
                text = "Continue with Google",
                fontSize = 16.sp,
                color = black,
                modifier = Modifier.weight(2f)
            )
        }
    }
}