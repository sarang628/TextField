package com.sryang.textfield.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun WritePrefix(prefix: String, onValueChange: (String) -> Unit) {
    Text(text = "prefix")
    BasicTextField(value = prefix, onValueChange = onValueChange, decorationBox = {
        Box(
            modifier = Modifier
                .height(25.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surfaceContainer),
            contentAlignment = Alignment.Center
        ) {
            Box(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                it.invoke()
            }
        }
    })
}