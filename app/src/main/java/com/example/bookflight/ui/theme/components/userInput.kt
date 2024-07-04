package com.example.bookflight.ui.theme.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookflight.ui.theme.darkGray
import com.example.bookflight.ui.theme.hintText
import com.example.bookflight.ui.theme.textFieldBG
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.bookflight.R
import com.example.bookflight.ui.theme.black
import com.example.bookflight.ui.theme.buttonBG
import com.example.bookflight.ui.theme.lightBlack

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserInput(userInput: MutableState<String>, keyboardType: KeyboardType, placeHolderText:String) {
    val color = if (isSystemInDarkTheme()) lightBlack else textFieldBG
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp),
        value = userInput.value,
        onValueChange = { userInput.value = it },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = color,
            unfocusedBorderColor = color,
            focusedTextColor = if (isSystemInDarkTheme()) Color.White else black,
            unfocusedContainerColor = color,
            focusedBorderColor = if (isSystemInDarkTheme()) buttonBG else darkGray,
        ),
        shape = RoundedCornerShape(9.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        placeholder = {
            Text(
                text = placeHolderText,
                fontSize = 15.sp,
                color = hintText
            )
        },
        singleLine = true,
    )
}


//
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserInputNumber(userInput: MutableState<String>) {
    val color = if (isSystemInDarkTheme()) lightBlack else textFieldBG
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(top = 5.dp),
        value = userInput.value,
        onValueChange = { userInput.value = it },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = color,
            unfocusedBorderColor = color,
            focusedTextColor = if (isSystemInDarkTheme()) Color.White else black,
            unfocusedContainerColor = color,
            focusedBorderColor = if (isSystemInDarkTheme()) buttonBG else darkGray,
        ),
        leadingIcon = {
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.flag),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Text(text = "+1", fontSize = 14.sp)
                Icon(
                    painter = painterResource(id = R.drawable.down_arrow),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Divider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(vertical = 10.dp)
                        .width((3).dp),
                    color = if (isSystemInDarkTheme()) darkGray else buttonBG
                )
            }
        },
        shape = RoundedCornerShape(9.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        placeholder = {
            Text(
                text = "1234-567-890",
                fontSize = 15.sp,
                color = hintText,
            )
        },
        singleLine = true,
    )
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserPassword(userInput: MutableState<String>, hint: String) {
    val color = if (isSystemInDarkTheme()) lightBlack else textFieldBG
    val isPasswordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp),
        value = userInput.value,
        onValueChange = { userInput.value = it },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = color,
            unfocusedBorderColor = color,
            focusedTextColor = if (isSystemInDarkTheme()) Color.White else black,
            unfocusedContainerColor = color,
            focusedBorderColor = if (isSystemInDarkTheme()) buttonBG else darkGray,
        ),
        shape = RoundedCornerShape(9.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        placeholder = {
            Text(
                text = hint,
                fontSize = 15.sp,
                color = hintText
            )
        },
        trailingIcon = {
            IconButton(onClick = { isPasswordVisible.value = !isPasswordVisible.value }) {
                if (!isPasswordVisible.value)
                    Icon(
                        painterResource(id = R.drawable.eye), modifier = Modifier.size(24.dp),
                        contentDescription = "Show Password", tint = darkGray
                    )
                else
                    Icon(
                        painterResource(id = R.drawable.eyeoff), modifier = Modifier.size(24.dp),
                        contentDescription = "Hide Password", tint = darkGray
                    )
            }

        },
        visualTransformation = if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        singleLine = true,
    )
}