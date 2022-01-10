package com.aleexalvz.sdk_user.utils

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.aleexalvz.sdk_user.ui.theme.SdkuserTheme


@Composable
fun Button_Login(onClick: ()->Unit) {

    SdkuserTheme {
        Button(onClick = onClick) {
            Text(text = "CLICK ME")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewComponents(){
    Button_Login {

    }
}




