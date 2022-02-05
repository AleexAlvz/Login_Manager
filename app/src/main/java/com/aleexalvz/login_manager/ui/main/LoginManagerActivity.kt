package com.aleexalvz.login_manager.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aleexalvz.login_manager.navigation.Routes
import com.aleexalvz.login_manager.ui.login.LoginScreen
import com.aleexalvz.login_manager.ui.register.RegisterScreen
import com.aleexalvz.login_manager.ui.theme.SdkuserTheme

class LoginManagerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SdkuserTheme {
                Surface(color = MaterialTheme.colors.background) {

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Routes.login) {
                        composable(Routes.login) { LoginScreen(navController = navController) }
                        composable(Routes.register) { RegisterScreen(navController = navController) }
                    }
                }
            }
        }
    }
}