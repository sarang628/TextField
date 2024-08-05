package com.sryang.textfield.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SelectKeyboardCapitalization(
    onChange: (KeyboardCapitalization) -> Unit,
) {

    Column {
        Chips(
            "KeyboardCapitalization",
            KeyboardCapitalization.None.toString(),
            KeyboardCapitalization.Words.toString(),
            KeyboardCapitalization.Sentences.toString(),
            KeyboardCapitalization.Characters.toString()
        ) {
            // @formatter:off
            when(it){
                KeyboardCapitalization.None.toString() -> onChange.invoke(KeyboardCapitalization.None)
                KeyboardCapitalization.Words.toString() -> onChange.invoke(KeyboardCapitalization.Words)
                KeyboardCapitalization.Sentences.toString() -> onChange.invoke(KeyboardCapitalization.Sentences)
                KeyboardCapitalization.Characters.toString() -> onChange.invoke(KeyboardCapitalization.Characters)
            }
            // @formatter:on
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectKeyboardCapitalizationPreview() {
    var keyboardCapitalization by remember { mutableStateOf(KeyboardCapitalization.None) }
    SelectKeyboardCapitalization(onChange = { keyboardCapitalization = it })
}