package com.sryang.textfield.compose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

fun getSupportingText(supportingText: String): @Composable (() -> Unit)? {
    return if (supportingText.isNotEmpty()) {
        {
            Text(text = supportingText)
        }
    } else {
        null
    }
}