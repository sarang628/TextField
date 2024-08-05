package com.sryang.textfield.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun SelectEanbled(onChange: (Boolean) -> Unit) {
    Column {
        Chips(title = "enabled", "true", "false") {
            onChange.invoke(it == "true")
        }
    }
}