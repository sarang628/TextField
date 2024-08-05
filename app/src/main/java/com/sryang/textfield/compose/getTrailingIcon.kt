package com.sryang.textfield.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

fun getTrailingIcon(trailingIcon: Boolean): @Composable (() -> Unit)? {
    return if (trailingIcon) {
        {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Clear, contentDescription = "")
            }
        }
    } else {
        null
    }
}