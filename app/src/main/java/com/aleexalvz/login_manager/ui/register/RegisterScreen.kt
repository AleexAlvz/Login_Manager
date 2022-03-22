package com.aleexalvz.login_manager.ui.register

import android.app.Application
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.aleexalvz.login_manager.model.User
import com.aleexalvz.login_manager.model.state.RegisterState
import com.aleexalvz.login_manager.navigation.Routes
import com.aleexalvz.login_manager.ui.theme.DarkBlue

@Composable
fun RegisterScreen(
    navController: NavController
) {

    val context = LocalContext.current
    val viewModel: RegisterViewModel =
        viewModel(factory = RegisterViewModel.Factory(context.applicationContext as Application))

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var numberPhone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    var loadingVisibility by remember { mutableStateOf(false) }
    val registerState by viewModel.uiRegisterState.observeAsState()

    LaunchedEffect(registerState){
        loadingVisibility = when (registerState) {
            is RegisterState.Failure -> {
                Toast.makeText(context, "Login failed", Toast.LENGTH_LONG).show()
                false
            }
            is RegisterState.Successful -> {
                navController.navigate(Routes.login)
                false
            }
            else -> false
        }
    }

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

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text(text = "Confirm password:") },
            modifier = Modifier
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Name:") },
            modifier = Modifier
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = numberPhone,
            onValueChange = { numberPhone = it },
            label = { Text(text = "Number phone:") },
            modifier = Modifier
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            label = { Text(text = "Address:") },
            modifier = Modifier
                .fillMaxWidth()
        )

        Button(
            onClick = {
                val user = User(name, email, password, numberPhone, address)
                viewModel.registerUser(user)
            },
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