package com.example.bookflight.ui.theme.Nav

sealed class RouteController (val route:String){
    data object Home :RouteController("Home")
    data object SplashScreen :RouteController("SplashScreen")
    data object LoginScreen :RouteController("LoginScreen")
    data object SignUpScreen :RouteController("SignUpScreen")
}