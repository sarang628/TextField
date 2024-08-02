package com.sryang.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sryang.textfield.ui.theme.KeyboardOptionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            KeyboardOptionsTheme {
                main1()
            }
        }
    }

    private val primaryColor = Color(0xFF2196F3)

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview(showBackground = true)
    @Composable
    fun main1() {
        var label by remember { mutableStateOf("") }
        var prefix by remember { mutableStateOf("") }
        var suffix by remember { mutableStateOf("") }
        var value by remember { mutableStateOf("") }
        var placeholder by remember { mutableStateOf("") }
        var keyboardCapitalization by remember { mutableStateOf(KeyboardCapitalization.None) }
        var keyboardType by remember { mutableStateOf(KeyboardType.Text) }
        var readOnly by remember { mutableStateOf(false) }
        var enabled by remember { mutableStateOf(true) }
        var leadingIcon by remember { mutableStateOf(true) }
        var trailingIcon by remember { mutableStateOf(true) }

        val labelCompose: @Composable (() -> Unit)? = if (label.isNotEmpty()) {
            { Text(text = label) }
        } else {
            null
        }

        val icon: @Composable (() -> Unit)? = if (label.isNotEmpty()) {
            { IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Face, contentDescription = "")
            } }
        } else {
            null
        }

        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "TextField Practice") })
            },
            modifier = Modifier.fillMaxSize(), contentWindowInsets = WindowInsets(
                top = 10.dp, left = 10.dp, right = 10.dp, bottom = 10.dp
            )
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                Column {
                    HorizontalDivider()
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = value,
                        onValueChange = { value = it },
                        modifier = Modifier.fillMaxWidth(),
                        enabled = enabled,
                        readOnly = readOnly,
                        label = labelCompose,
                        placeholder = { Text(text = placeholder) },
                        leadingIcon = if (leadingIcon) {
                            { IconButton(onClick = {}) {
                                Icon(imageVector = Icons.Default.Face, contentDescription = "")
                            } }
                        } else {
                            null
                        },
                        trailingIcon = if (trailingIcon) {
                            { IconButton(onClick = {}) {
                                Icon(imageVector = Icons.Default.Clear, contentDescription = "")
                            } }
                        } else {
                            null
                        },
                        prefix = { Text(text = prefix) },
                        suffix = { Text(text = suffix) },
                        supportingText = { Text(text = "supportingText") },
                        isError = false,
                        keyboardOptions = KeyboardOptions(
                            capitalization = keyboardCapitalization,
                            keyboardType = keyboardType,
                        ),
                        //shape = CircleShape,
                        //visualTransformation = PasswordVisualTransformation(mask = '\u2023'),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    HorizontalDivider()
                    SelectKeyboardCapitalization { keyboardCapitalization = it }
                    SelectKeyboardType { keyboardType = it }
                    SelectReadOnly { readOnly = it }
                    SelectEanbled { enabled = it }

                    Text(text = "label")
                    BasicTextField(
                        value = label,
                        onValueChange = { label = it },
                        decorationBox = {
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
                        }
                    )

                    Text(text = "prefix")
                    BasicTextField(
                        value = prefix,
                        onValueChange = { prefix = it },
                        decorationBox = {
                            Box(
                                modifier = Modifier
                                    .height(25.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(MaterialTheme.colorScheme.surfaceContainer),
                                contentAlignment = Alignment.Center
                            )
                            {
                                Box(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                                    it.invoke()
                                }
                            }
                        }
                    )

                    Text(text = "suffix")
                    BasicTextField(
                        value = suffix,
                        onValueChange = { suffix = it },
                        decorationBox = {
                            Box(
                                modifier = Modifier
                                    .height(25.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(MaterialTheme.colorScheme.surfaceContainer),
                                contentAlignment = Alignment.Center
                            )
                            {
                                Box(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                                    it.invoke()
                                }
                            }
                        }
                    )
                    Text(text = "value")
                    BasicTextField(
                        value = value,
                        onValueChange = { value = it },
                        decorationBox = {
                            Box(
                                modifier = Modifier
                                    .height(25.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(MaterialTheme.colorScheme.surfaceContainer),
                                contentAlignment = Alignment.Center
                            )
                            {
                                Box(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                                    it.invoke()
                                }
                            }
                        }
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "leadingIcon")
                        Spacer(modifier = Modifier.width(8.dp))
                        Switch(checked = leadingIcon, onCheckedChange = { leadingIcon = it })
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "trailingIcon")
                        Spacer(modifier = Modifier.width(8.dp))
                        Switch(checked = trailingIcon, onCheckedChange = { trailingIcon = it })
                    }
                }
            }
        }
    }

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

    @Composable
    fun SelectKeyboardType(
        onChange: (KeyboardType) -> Unit = {},
    ) {
        Column {
            Chips(
                "KeyboardType",
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

    @Composable
    fun SelectReadOnly(onChange: (Boolean) -> Unit) {
        Column {
            Chips(title = "readOnly", "false", "true") {
                onChange.invoke(it == "true")
            }
        }
    }

    @Composable
    fun SelectEanbled(onChange: (Boolean) -> Unit) {
        Column {
            Chips(title = "enabled", "true", "false") {
                onChange.invoke(it == "true")
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun test() {
        Chips("test", "b", "c") {

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun SelectKeyboardCapitalizationPreview() {
        var keyboardCapitalization by remember { mutableStateOf(KeyboardCapitalization.None) }
        SelectKeyboardCapitalization(
            onChange = { keyboardCapitalization = it })
    }


    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    fun Chips(title: String, vararg key: String, onClick: (String) -> Unit) {
        var selectedKey by remember { mutableStateOf(key[0]) }
        Column {
            Text(text = title)
            FlowRow(
                horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()
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
}
