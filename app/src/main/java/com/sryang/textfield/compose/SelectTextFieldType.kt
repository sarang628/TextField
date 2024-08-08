package com.sryang.textfield.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun SelectTextFieldType(
    onChange: (String) -> Unit = {},
) {
    Column {
        Chips(
            "TextField",
            "TextField",
            "OutlinedTextField",
            "BasicSecureTextField",
            "BasicTextField",
            "BasicTextField2"
        ) {
            // @formatter:off
            when(it){
                "TextField" -> onChange.invoke("TextField")
                "OutlinedTextField" -> onChange.invoke("OutlinedTextField")
                "BasicSecureTextField" -> onChange.invoke("BasicSecureTextField")
                "BasicTextField" -> onChange.invoke("BasicTextField")
                "BasicTextField2" -> onChange.invoke("BasicTextField2")
            }
            // @formatter:on
        }
    }
}