package com.sryang.textfield.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

private val primaryColor = Color(0xFF2196F3)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Chips(title: String, vararg key: String, onClick: (String) -> Unit) {

    var selectedKey by remember { mutableStateOf(key[0]) }
    Column {
        Text(text = title)
        FlowRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            key.forEach {
                AssistChip(
                    onClick = {
                        selectedKey = it
                        onClick.invoke(it)
                    },
                    label = {
                        Text(
                            text = it,
                            color = if (it == selectedKey) Color.White else Color.Black
                        )
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (it == selectedKey) primaryColor else Color.Unspecified
                    ),
                    border = if (it != selectedKey) AssistChipDefaults.assistChipBorder(true) else null,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChipsPreview() {
    Chips("test", "b", "c") {
    }
}