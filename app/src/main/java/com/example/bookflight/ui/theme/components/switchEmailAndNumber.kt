package com.example.bookflight.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookflight.ui.theme.black
import com.example.bookflight.ui.theme.currentText
import com.example.bookflight.ui.theme.subtitleGray

@Composable
fun SwitchEmailAndNumber(
    isClicked: MutableState<Boolean>,
    isPhoneNumberClicker: MutableState<Boolean>
) {
    Box(
        modifier = Modifier
            .requiredWidth(230.dp)
            .height(45.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextButton(onClick = {
                    isPhoneNumberClicker.value = false
                    isClicked.value = true
                }, modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Email",
                        fontSize = 18.sp,
                        color = if (isClicked.value) currentText else subtitleGray
                    )
                }
                if (isClicked.value) {
                    Divider(
                        modifier = Modifier
                            .size(24.dp, 2.dp)
                            .weight(.1f), color = currentText, thickness = 2.dp
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextButton(onClick = {
                    isPhoneNumberClicker.value = true
                    isClicked.value = false
                }, modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Phone Number",
                        fontSize = 18.sp,
                        color = if (isPhoneNumberClicker.value) currentText else subtitleGray
                    )
                }
                if (isPhoneNumberClicker.value) {
                    Divider(
                        modifier = Modifier
                            .size(24.dp, 2.dp)
                            .weight(.1f), color = currentText, thickness = 2.dp
                            )

                }
            }
        }
    }
}