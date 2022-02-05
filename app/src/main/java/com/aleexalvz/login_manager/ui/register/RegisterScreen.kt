package com.aleexalvz.login_manager.ui.register

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aleexalvz.login_manager.ui.theme.BackgroundGrey

@ExperimentalAnimationApi
@Composable
fun RegisterScreen() {

    val name by remember { mutableStateOf("") }
    val lastName by remember { mutableStateOf("") }
    val email by remember { mutableStateOf("") }
    val password by remember { mutableStateOf("") }
    val numberPhone by remember { mutableStateOf("") }
    val address by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Text(
            text = "Criar conta",
            fontSize = 64.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        var stepRegisterState by remember { mutableStateOf(StepRegisterState.requiredInfo) }

        AnimatedContent(targetState = stepRegisterState) { target ->

        }
    }
}

@Preview
@Composable
fun CardStep(text: String = "TESTE", expanded: Boolean = true) {

    Card(
        backgroundColor = BackgroundGrey,
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(20)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Text(text = text, fontSize = 20.sp)

            Card(
                modifier = Modifier.animateContentSize()
            ) {
                if (expanded){

                }
            }

        }
    }

}


