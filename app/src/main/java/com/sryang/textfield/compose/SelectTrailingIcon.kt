package com.sryang.textfield.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SelectTrailingIcon(trailingIcon: Boolean, onCheckedChange: ((Boolean) -> Unit)?) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "trailingIcon")
        Spacer(modifier = Modifier.width(8.dp))
        Switch(checked = trailingIcon, onCheckedChange = onCheckedChange)
    }
}