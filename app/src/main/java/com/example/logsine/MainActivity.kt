package com.example.logsine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            // like one activity to another activity move
            var navController = rememberNavController()
            NavHost(navController = navController, startDestination = "login" , builder = {
                composable("login"){
                    login(navController)

                }

                composable("signUp"){
                   Sineup(navController)
                }
            })


        }
    }
}




