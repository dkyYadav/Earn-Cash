package com.example.EarnCash

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ForgetPass(navController: NavController) {

    Column (modifier = Modifier
        .padding(top = 35.dp, start = 15.dp, end = 15.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){

        Text(text = "Forgot password?",  color = colorResource(R.color.black),
            fontSize = 55.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        var fpassword by remember { mutableStateOf("") }

        OutlinedTextField(
            value = fpassword,
            onValueChange = {
                fpassword = it
            },
            label = {
                Text("Enter your email address")
            }, modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email"
                )
            }
        )


        Spacer(modifier = Modifier.height(20.dp))

        Text("* We will send you a message to set or reset your new password",
            modifier = Modifier, fontSize = 20.sp)


        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {}
            ,modifier = Modifier
                .fillMaxWidth().padding(start = 50.dp, end = 50.dp).height(55.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = colorResource(R.color.white),
                containerColor = colorResource(R.color.pink)
            ),
            shape = RoundedCornerShape(
                topStart = 50.dp,
                topEnd = 0.dp,
                bottomStart = 0.dp,
                bottomEnd = 50.dp
            ),
        ) {
            Text("Forget Password")
        }

    }

}