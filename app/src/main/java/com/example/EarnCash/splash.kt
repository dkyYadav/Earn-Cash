package com.example.EarnCash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun Splash(navController: NavController) {

    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate("login") {
            popUpTo("Splash"){inclusive = true }
        }
    }

    Box (modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(R.drawable.logo),
            contentDescription = "logo",
            //modifier = Modifier.size(100.dp).padding(10.dp)
        )  }

}