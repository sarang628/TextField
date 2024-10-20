package com.sryang.textfield.compose.customtextfield

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun SelectSingleLine(onChange: (Boolean) -> Unit) {
    Column {
        Chips(title = "singleLine", "true", "false") {
            onChange.invoke(it == "true")
        }
    }
}