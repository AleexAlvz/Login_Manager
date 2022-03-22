package com.aleexalvz.login_manager.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun EmailTextField(email: String) {

    var emailField = email

    OutlinedTextField(
        value = emailField,
        onValueChange = { emailField = it },
        label = { Text(text = "Email:") },
        modifier = Modifier
            .fillMaxWidth()
    )
}
