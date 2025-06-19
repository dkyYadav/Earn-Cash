package com.example.EarnCash

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavCnt() {

    // like one activity to another activity move
    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Splash" , builder = {

        composable("Splash"){
            Splash(navController)
        }

        composable("login"){
            login(navController)

        }

        composable("signUp"){
            Sineup(navController)
        }

        composable("forgetPass"){
            ForgetPass(navController)
        }
    })

}