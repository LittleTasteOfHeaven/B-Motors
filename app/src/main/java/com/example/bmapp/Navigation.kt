package com.example.bmapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bmapp.screens.Home
import com.example.bmapp.screens.Service

@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            Home(navController = navController)
        }
        composable(
            route = "services?categoryName={categoryName}",
            arguments = listOf(navArgument("categoryName") { defaultValue = "" })
        ) {
            Service(
                navController = navController,
                categoryName = it.arguments?.getString("categoryName") ?: ""
            )
        }
    }
}
