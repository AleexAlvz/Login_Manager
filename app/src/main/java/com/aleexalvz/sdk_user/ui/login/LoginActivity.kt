package com.aleexalvz.sdk_user.ui.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aleexalvz.sdk_user.ui.theme.DarkBlue
import com.aleexalvz.sdk_user.ui.theme.SdkuserTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SdkuserTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LoginScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreen() {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxSize()
    ) {

        Icon(
            Icons.Default.Person,
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
            onValueChange = { },
            label = { Text(text = "Email:") },
            modifier = Modifier
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = { },
            label = { Text(text = "Senha:") },
            modifier = Modifier
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Button(onClick = { /*TODO*/}, modifier = Modifier
            .padding(top = 32.dp)
            .align(Alignment.CenterHorizontally)
            .size(
                width = 200.dp,
                height = 50.dp
            ), colors = ButtonDefaults.buttonColors(backgroundColor = DarkBlue)){
            Text("Login", fontSize = 20.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.size(16.dp))

        Button(onClick = { /*TODO*/}, modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .size(
                width = 200.dp,
                height = 50.dp
            ), colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray) ){
            Text("Criar uma conta", fontSize = 20.sp, color = Color.White)
        }
    }
}