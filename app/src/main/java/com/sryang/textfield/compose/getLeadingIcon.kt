package com.sryang.textfield.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

fun getLeadingIcon(leadingIcon: Boolean = true): @Composable (() -> Unit)? {
    return if (leadingIcon) {
        {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Face, contentDescription = "")
            }
        }
    } else {
        null
    }
}