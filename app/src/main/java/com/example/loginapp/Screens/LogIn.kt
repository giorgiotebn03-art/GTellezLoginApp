package com.example.loginapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade

@Composable
fun LogIn(
    navController : NavController
){
    //Vista completa
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        //Imagen de encabezado
        Column (
            modifier = Modifier

                .clip(RoundedCornerShape(16.dp))
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(
                modifier = Modifier
                    .weight(1f)
                    .size(120.dp)
                    .padding(top = 40.dp, bottom = 40.dp)
                    .clip( RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp, bottomEnd = 16.dp))
                    .background(Color.Transparent)

            ){
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://static.wikia.nocookie.net/lego-marvelsuperheroes/images/2/2a/Mysterio.jpg/revision/latest/thumbnail/width/360/height/360?cb=20131004213843")
                        .crossfade(true)
                        .build(),
                    contentDescription = "Imagen de prueba",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            //Formulario LogIn
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 48.dp))
                    .background(Color.White)
                    .padding(top = 20.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text= "Log In",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(20.dp)
                )
                var email by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                Column (
                    modifier = Modifier
                        .background(Color.White)
                        .padding(25.dp)
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                            .shadow(16.dp)
                            .clip( RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp, bottomEnd = 16.dp))


                    )

                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        singleLine = true,
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                            .shadow(16.dp)
                            .clip( RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp, bottomEnd = 16.dp))
                    )
                    Button(
                        onClick = {
                            navController.navigate(LogIn)
                        },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black, // Fondo negro
                            contentColor = Color.White     // Texto blanco
                        ),
                        modifier = Modifier
                            .clip( RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp, bottomEnd = 16.dp))
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                            .shadow(16.dp)
                    ) {
                        Text(text = "Login")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SignUpnPreview(){
    SignUp(navController = rememberNavController())
}