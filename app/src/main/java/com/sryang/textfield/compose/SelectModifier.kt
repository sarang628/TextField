package com.sryang.textfield.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SelectModifier(height: Int, onValueChange: (Float) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "height($height)")
        Spacer(modifier = Modifier.width(8.dp))
        Slider(
            value = height.toFloat(), onValueChange = onValueChange, valueRange = 1f..100f
        )
    }
}

@Preview
@Composable
fun PreviewSelectModifier() {
    SelectModifier(height = 0) {

    }
}