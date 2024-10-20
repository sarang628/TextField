package com.sryang.textfield.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun TextFieldWithDescription() {

    Column {
        Text(
            "Material Design filled text field.\n\n" +
                    "Text fields allow users to enter text into a UI.\nThey typically appear in forms and dialogs.\nFilled text fields have more visual emphasis than outlined text fields,\nmaking them stand out when surrounded by other content and components.\n" +
                    "https://m3.material.io/components/text-fields/overview"
        )
        Spacer(modifier = Modifier.height(20.dp))
        ProvideTextFieldWithDescription()
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = "",
            placeholder = { Text("placeholder") },
            onValueChange = {},
            leadingIcon = {
                Icon(Icons.Default.Face, "")
            },
            trailingIcon = {
                Icon(Icons.AutoMirrored.Default.Send, "")
            }
        )
    }
}

@Composable
fun ProvideTextFieldWithDescription() {
    TextField(
        value = "value",
        onValueChange = {},
        prefix = { Text("prefix") },
        suffix = { Text("suffix") },
        label = { Text("label") },
        supportingText = { Text("supportingText") },
        isError = true,
    )
}