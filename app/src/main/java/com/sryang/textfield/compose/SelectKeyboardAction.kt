package com.sryang.textfield.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun SelectKeyboardAction(
    onChange: (KeyboardType) -> Unit = {},
) {
    Column {
        Chips(
            "SelectKeyboardAction",
            KeyboardType.Text.toString(),
            KeyboardType.Ascii.toString(),
            KeyboardType.Number.toString(),
            KeyboardType.Phone.toString(),
            KeyboardType.Uri.toString(),
            KeyboardType.Email.toString(),
            KeyboardType.Password.toString(),
            KeyboardType.NumberPassword.toString(),
            KeyboardType.Decimal.toString()
        ) {
            // @formatter:off
            when(it){
                KeyboardType.Text.toString() -> onChange.invoke(KeyboardType.Text)
                KeyboardType.Ascii.toString() -> onChange.invoke(KeyboardType.Ascii)
                KeyboardType.Number.toString() -> onChange.invoke(KeyboardType.Number)
                KeyboardType.Phone.toString() -> onChange.invoke(KeyboardType.Phone)
                KeyboardType.Uri.toString() -> onChange.invoke(KeyboardType.Uri)
                KeyboardType.Email.toString() -> onChange.invoke(KeyboardType.Email)
                KeyboardType.Password.toString() -> onChange.invoke(KeyboardType.Password)
                KeyboardType.NumberPassword.toString() -> onChange.invoke(KeyboardType.NumberPassword)
                KeyboardType.Decimal.toString() -> onChange.invoke(KeyboardType.Decimal)
            }
            // @formatter:on
        }
    }
}