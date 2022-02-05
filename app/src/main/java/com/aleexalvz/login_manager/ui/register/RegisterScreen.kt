package com.aleexalvz.login_manager.ui.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aleexalvz.login_manager.navigation.Routes
import com.aleexalvz.login_manager.ui.theme.DarkBlue

@Composable
fun RegisterScreen(
    navController: NavController
) {

    val email by remember { mutableStateOf("") }
    val password by remember { mutableStateOf("") }
    val confirmPassword by remember { mutableStateOf("") }
    val name by remember { mutableStateOf("") }
    val lastName by remember { mutableStateOf("") }
    val numberPhone by remember { mutableStateOf("") }
    val address by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(32.dp)
            .fillMaxSize()
    ) {

        Text(
            text = "Register",
            fontSize = 64.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = email,
            onValueChange = { },
            label = { Text(text = "Email:") },
            modifier = Modifier
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = { },
            label = { Text(text = "Password:") },
            modifier = Modifier
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { },
            label = { Text(text = "Confirm password:") },
            modifier = Modifier
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        OutlinedTextField(
            value = name,
            onValueChange = { },
            label = { Text(text = "Name:") },
            modifier = Modifier
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        OutlinedTextField(
            value = lastName,
            onValueChange = { },
            label = { Text(text = "Last name:") },
            modifier = Modifier
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        OutlinedTextField(
            value = numberPhone,
            onValueChange = { },
            label = { Text(text = "Number phone:") },
            modifier = Modifier
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        OutlinedTextField(
            value = address,
            onValueChange = { },
            label = { Text(text = "Address:") },
            modifier = Modifier
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            onClick = { navController.navigate(Routes.login) },
            modifier = Modifier
                .padding(top = 32.dp)
                .align(Alignment.CenterHorizontally)
                .size(
                    width = 200.dp,
                    height = 50.dp
                ),
            colors = ButtonDefaults.buttonColors(backgroundColor = DarkBlue),
            shape = RoundedCornerShape(20)
        ) {
            Text("Create account", fontSize = 20.sp, color = Color.White)
        }
    }
}