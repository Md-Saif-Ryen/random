package com.example.bookflight.ui.theme.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bookflight.ui.theme.Nav.RouteController
import com.example.bookflight.ui.theme.black
import com.example.bookflight.ui.theme.components.BorderOption
import com.example.bookflight.ui.theme.components.ButtonGoogle
import com.example.bookflight.ui.theme.components.ButtonLogin
import com.example.bookflight.ui.theme.components.HeaderText
import com.example.bookflight.ui.theme.components.SwitchEmailAndNumber
import com.example.bookflight.ui.theme.components.UserInput
import com.example.bookflight.ui.theme.components.UserPassword
import com.example.bookflight.ui.theme.currentText
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen(navController: NavController) {
    val color = if (isSystemInDarkTheme()) Color.White else black
    val snackBar = remember {
        SnackbarHostState()
    }
    val scope = rememberCoroutineScope()
    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            modifier = Modifier.padding(20.dp),
            snackbarHost = { SnackbarHost(hostState = snackBar) }
        ) { i ->
            val userInput = remember {
                mutableStateOf("")
            }
            val userInputName = remember {
                mutableStateOf("")
            }
            val userPassword = remember {
                mutableStateOf("")
            }
            val labelText = "Email Address"
            Column(
                modifier = Modifier
                    .padding(i)
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                Text(text = "Create an Account", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(40.dp))
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Name", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                UserInput(
                    userInputName,
                    KeyboardType.Text,
                    "John"
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = labelText, fontSize = 16.sp, fontWeight = FontWeight.Medium)
                UserInput(
                    userInput,
                    KeyboardType.Email,
                    "abc@gmail.com"
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Password", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                    Text(text = "Forget Password?", fontSize = 14.sp, color = currentText)

                }
                UserPassword(userPassword, "*******")
                Spacer(modifier = Modifier.height(40.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(text = "By continuing, you agree to our", fontSize = 13.sp, color = color)
                    Text(text = "terms of Service", fontSize = 15.sp, color = currentText)
                }
                Spacer(modifier = Modifier.height(20.dp))
                ButtonLogin("Sign Up") {
                    if (userInput.value.isNotEmpty()) {
                        if (userPassword.value.isNotEmpty()) {
                            if (userPassword.value.length < 7) {
                                scope.launch {
                                    snackBar.showSnackbar(
                                        "Password length should be 8 or greater than 8",
                                        withDismissAction = true,
                                        duration = SnackbarDuration.Short,
                                    )
                                }
                            } else {
                                navController.popBackStack()
                                navController.navigate(RouteController.Home.route)
                            }

                        } else {
                            scope.launch {
                                snackBar.showSnackbar(
                                    "Something is missing",
                                    withDismissAction = true,
                                    duration = SnackbarDuration.Short,
                                )
                            }
                        }

                    } else {
                        scope.launch {
                            snackBar.showSnackbar(
                                "Something is missing",
                                withDismissAction = true,
                                duration = SnackbarDuration.Short,
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                BorderOption("OR")
                Spacer(modifier = Modifier.height(15.dp))
                ButtonGoogle() {
                    scope.launch {
                        snackBar.showSnackbar(
                            "Something is miss",
                            withDismissAction = true,
                            duration = SnackbarDuration.Short,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(45.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Already Have an Account?",
                        fontSize = 16.sp,
                        color = color,
                        modifier = Modifier
                            .align(Alignment.Bottom)

                    )
                    Text(
                        text = "Sign in Here",
                        fontSize = 16.sp,
                        color = currentText,
                        modifier = Modifier
                            .align(Alignment.Bottom)
                            .clickable { navController.popBackStack()
                                navController.navigate(RouteController.LoginScreen.route)}

                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun preveiew() {
    val navController = rememberNavController()
    SignUpScreen(navController = navController)

}