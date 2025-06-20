package com.example.EarnCash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun Home(navController: NavController) {


    val auth = Firebase.auth

    Box(modifier = Modifier.fillMaxSize(), Alignment.Center

    ) {
        Column(
            verticalArrangement = Arrangement.Center,

        ) {
            Text("Hello, ${auth.currentUser?.email}", fontSize = 25.sp)

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                auth.signOut()
                navController.navigate("Login"){
                    popUpTo("Home"){inclusive =true}
                }

            }) {
                Text("LogOut")
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun Homepre(){
    Home(navController = rememberNavController())
}