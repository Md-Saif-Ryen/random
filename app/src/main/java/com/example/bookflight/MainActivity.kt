package com.example.bookflight

import android.content.res.Configuration
import android.graphics.Bitmap.Config
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookflight.ui.theme.BookFlightTheme
import com.example.bookflight.ui.theme.Nav.RouteController
import com.example.bookflight.ui.theme.Screens.Home
import com.example.bookflight.ui.theme.Screens.LoginScreen
import com.example.bookflight.ui.theme.Screens.SignUpScreen
import com.example.bookflight.ui.theme.Screens.SplashScreen
import com.example.bookflight.ui.theme.darkGray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookFlightTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(darkGray)
                            .fillMaxSize()
                    ) {

                    }
                    NavHost(
                        navController = navController,
                        startDestination = RouteController.LoginScreen.route
                    ) {
                        composable(RouteController.SplashScreen.route) { SplashScreen(navController = navController) }
                        composable(RouteController.Home.route) { Home() }
                        composable(RouteController.LoginScreen.route) { LoginScreen(navController = navController) }
                        composable(RouteController.SignUpScreen.route) { SignUpScreen(navController = navController) }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
 fun prev() {
val navController = rememberNavController()
     LoginScreen(navController =navController )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
 fun nightPrev() {
val navController = rememberNavController()
     LoginScreen(navController =navController )
}