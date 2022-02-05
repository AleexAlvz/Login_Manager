package com.aleexalvz.login_manager.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.aleexalvz.login_manager.navigation.Routes
import com.aleexalvz.login_manager.ui.theme.DarkBlue

@Composable
fun LoginScreen(
    navController: NavController
) {
    val viewModel = LoginViewModel()

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(32.dp)
            .fillMaxSize()
    ) {

        Icon(
            Icons.Default.AccountCircle,
            contentDescription = "User Icon",
            modifier = Modifier
                .size(150.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = "Login",
            fontSize = 64.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email:") },
            modifier = Modifier
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password:") },
            modifier = Modifier
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            onClick = {
                viewModel.login(email, password)
            },
            modifier = Modifier
                .padding(top = 32.dp)
                .align(Alignment.CenterHorizontally)
                .size(
                    width = 230.dp,
                    height = 50.dp
                ),
            colors = ButtonDefaults.buttonColors(backgroundColor = DarkBlue),
            shape = RoundedCornerShape(20)
        ) {
            Text("Login", fontSize = 20.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.size(16.dp))

        Button(
            onClick = {
                navController.navigate(Routes.register)
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(
                    width = 230.dp,
                    height = 50.dp
                ), colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
            shape = RoundedCornerShape(20)
        ) {
            Text("Create an account", fontSize = 20.sp, color = Color.White)
        }
    }
}