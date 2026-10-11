package com.example.flowcast.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flowcast.FlowCastApp
import com.example.flowcast.ui.screens.SplashScreen
import com.example.flowcast.ui.screens.login.LoginScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination ="splash"
    ){
        composable("splash") {
            SplashScreen(
                onNavigateToNext = {
                    navController.navigate("login") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            )
        }

        composable("login"){
            LoginScreen(
                onLoginSuccess = {
                        navController.navigate("main") {
                            popUpTo("login") { inclusive = true }
                        }
                }
            )
        }

        composable ("main"){
            FlowCastApp()
        }
    }
}
