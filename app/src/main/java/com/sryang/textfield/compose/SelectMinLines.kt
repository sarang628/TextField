package com.sryang.textfield.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SelectMinLines(minLines: Int, onValueChange: (Float) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "minLines($minLines)")
        Spacer(modifier = Modifier.width(8.dp))
        Slider(
            value = minLines.toFloat(), onValueChange = onValueChange, valueRange = 1f..10f
        )
    }
}