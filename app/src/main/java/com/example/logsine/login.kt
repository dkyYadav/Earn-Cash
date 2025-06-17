package com.example.logsine


import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import java.nio.file.WatchEvent


@Composable
fun login(navController: NavController) {



    Box (modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
    ElevatedCard (
        elevation = CardDefaults.cardElevation(10.dp),
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()


        ){
         Column (
     modifier = Modifier.padding(20.dp),
     horizontalAlignment = Alignment.CenterHorizontally,
     verticalArrangement = Arrangement.Center
 ){
     Image(painter = painterResource(R.drawable.logo),
         contentDescription = "logo",
         modifier = Modifier.size(100.dp).padding(10.dp)
     )


     var email by remember {
         mutableStateOf("")
     }


     Spacer(modifier = Modifier.height(10.dp))
     OutlinedTextField(
         value = email,
         onValueChange = {
             email = it
         },
         label = {
             Text("Email", fontSize = 15.sp)
         }

     )

     Spacer(modifier = Modifier.height(10.dp))
     var password by remember { mutableStateOf("") }
     OutlinedTextField(
         value = password,
         onValueChange = {
             password = it
         },
         label = {
             Text("Password", fontSize = 15.sp)
         }

     )

     Spacer(modifier = Modifier.height(8.dp))


     Row {

         Text(
             "Don't have an account?",
             color = colorResource(R.color.brown),
             fontSize = 15.sp
         )

         Text(
             " Register ",
             color = colorResource(R.color.brown),
             fontSize = 15.sp
         )
     }

     Spacer(modifier = Modifier.height(30.dp),)

     Button(
         colors = ButtonDefaults.buttonColors(
             contentColor = Color.Black,
             containerColor = colorResource(R.color.brown)
         ),
         modifier = Modifier
             .height(50.dp)
             .width(150.dp),
         onClick = {
             navController.navigate("signUp")
         }

     ) {
         Text("Login")

     }


 }

    }

}

}

@Composable
@Preview(showSystemUi = true)
fun logpre(){
    login(navController = rememberNavController())
}



