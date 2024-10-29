package com.example.juego

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.juego.composables.pantalla1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "pantalla1"
            ){
                composable("pantalla1") { pantalla1(navController, "1", "2", "1") }
                //fun pantalla1(navHostController: NavHostController, pointsP1: String, pointsP2: String, eleccion: String){
                composable("pantalla1/{pointsP1}/{pointsP2}/{eleccion}"){ backStackEntry ->
                    pantalla1(navController,
                        backStackEntry.arguments?.getString("pointsP1").toString(),
                        backStackEntry.arguments?.getString("pointsP2").toString(),
                        backStackEntry.arguments?.getString("eleccion").toString())
                }
            }
        }
    }
}