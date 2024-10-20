package com.sryang.textfield.compose.customtextfield

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun SelectReadOnly(onChange: (Boolean) -> Unit) {
    Column {
        Chips(title = "readOnly", "false", "true") {
            onChange.invoke(it == "true")
        }
    }
}