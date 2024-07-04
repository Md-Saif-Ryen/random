package com.example.bookflight.ui.theme.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookflight.ui.theme.subtitleGray

@Composable
@Preview
fun BorderOption(text:String ,modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(25.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            thickness = (.5f).dp,
            color =if (isSystemInDarkTheme()) Color.White else subtitleGray,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        Text(
            text =text,
            color = if (isSystemInDarkTheme()) Color.White else subtitleGray, fontSize = 14.sp
            , modifier = Modifier.padding(horizontal = 4.dp)
        )
        Divider(
            thickness = (.5f).dp,
            color =if (isSystemInDarkTheme()) Color.White else subtitleGray,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
    }
}