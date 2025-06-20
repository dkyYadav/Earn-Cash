package com.example.EarnCash

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.contracts.contract


@Composable
fun SignUp(navController: NavController) {

    val context = LocalContext.current

    val auth = Firebase.auth

    Box (modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        ElevatedCard (
            elevation = CardDefaults.cardElevation(10.dp),
            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                .wrapContentWidth()
                .wrapContentHeight()


        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center


            ) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "logo",
                    modifier = Modifier.size(100.dp).padding(10.dp)
                )


                /*var `name-text` by rememberSaveable {
                    mutableStateOf("")
                }

                OutlinedTextField(
                    value = `name-text`,
                    onValueChange = {
                        `name-text` = it
                    },
                    label = {
                        Text("Username", fontSize = 15.sp)
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Person"
                        )
                    }


                )*/

                Spacer(modifier = Modifier.height(10.dp))
                var email by rememberSaveable {
                    mutableStateOf("")
                }
                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    label = {
                        Text("Email", fontSize = 15.sp)
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "Email"
                        )
                    }

                )

                Spacer(modifier = Modifier.height(10.dp))
                var password by rememberSaveable { mutableStateOf("") }
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    label = {
                        Text("Password", fontSize = 15.sp)
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Lock"
                        )
                    },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_eye),
                            contentDescription = "eye",
                            modifier = Modifier.size(24.dp),
                        )
                    }
                )

               /* Spacer(modifier = Modifier.height(10.dp))
                var repass by rememberSaveable {
                    mutableStateOf("")
                }
                OutlinedTextField(
                    value = repass,
                    onValueChange = {
                        repass = it
                    },
                    label = {
                        Text("ConfirmPassword", fontSize = 15.sp)
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Lock"
                        )
                    },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_eye),
                            contentDescription = "eye",
                            modifier = Modifier.size(24.dp),
                        )
                    }
                )
*/
                Spacer(modifier = Modifier.height(30.dp))

                Button(onClick = {
                    // firebase to  signup

                    auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful){
                                navController.navigate("Home")
                            }else{
                                Toast.makeText(context,task.exception?.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                }
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
                    Text("Create Account")
                }

                Spacer(modifier = Modifier.height(30.dp))

                Row {

                    Text(
                        "Already have an account?",
                        color = colorResource(R.color.black),
                        fontSize = 15.sp
                    )

                    Text(
                        " LOGIN ",
                        color = colorResource(id = R.color.pink),
                        fontSize = 15.sp,
                        modifier = Modifier.clickable{
                            navController.navigate("Login")

                        }
                    )
                }


            }

        }
    }
}
@Composable
@Preview(showSystemUi = true)
fun Signpre(){

    SignUp(navController = rememberNavController())
}


