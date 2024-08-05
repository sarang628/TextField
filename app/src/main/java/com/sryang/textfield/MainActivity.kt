package com.sryang.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sryang.textfield.compose.Chips
import com.sryang.textfield.compose.SelectEanbled
import com.sryang.textfield.compose.SelectIsError
import com.sryang.textfield.compose.SelectKeyboardCapitalization
import com.sryang.textfield.compose.SelectKeyboardType
import com.sryang.textfield.compose.SelectLeadingIcon
import com.sryang.textfield.compose.SelectMaxLines
import com.sryang.textfield.compose.SelectMinLines
import com.sryang.textfield.compose.SelectReadOnly
import com.sryang.textfield.compose.SelectShape
import com.sryang.textfield.compose.SelectSingleLine
import com.sryang.textfield.compose.SelectTrailingIcon
import com.sryang.textfield.compose.WriteLabel
import com.sryang.textfield.compose.WritePlaceholder
import com.sryang.textfield.compose.WritePrefix
import com.sryang.textfield.compose.WriteSuffix
import com.sryang.textfield.compose.WriteSupportingText
import com.sryang.textfield.compose.WriteValue
import com.sryang.textfield.compose.getLeadingIcon
import com.sryang.textfield.compose.getSupportingText
import com.sryang.textfield.compose.getTrailingIcon
import com.sryang.textfield.ui.theme.KeyboardOptionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            KeyboardOptionsTheme {
                CustomTextField()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview(showBackground = true)
    @Composable
    fun CustomTextField() {
        val navController = rememberNavController()
        Scaffold(
            topBar = {
                TopAppBar(navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = ""
                        )
                    }
                }, title = { Text(text = "TextField Practice") })
            }, modifier = Modifier.fillMaxSize(), contentWindowInsets = WindowInsets(
                top = 10.dp, left = 10.dp, right = 10.dp, bottom = 10.dp
            )
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                CustomTextField1(navController)
            }
        }
    }

    @Composable
    fun CustomTextField1(navController: NavHostController) {
        var label by remember { mutableStateOf("") }
        var prefix by remember { mutableStateOf("") }
        var suffix by remember { mutableStateOf("") }
        var value by remember { mutableStateOf("") }
        var placeholder by remember { mutableStateOf("") }
        var supportingText by remember { mutableStateOf("") }
        var keyboardCapitalization by remember { mutableStateOf(KeyboardCapitalization.None) }
        var keyboardType by remember { mutableStateOf(KeyboardType.Text) }
        var readOnly by remember { mutableStateOf(false) }
        var enabled by remember { mutableStateOf(true) }
        var singleLine by remember { mutableStateOf(false) }
        var leadingIcon by remember { mutableStateOf(true) }
        var trailingIcon by remember { mutableStateOf(true) }
        var isError by remember { mutableStateOf(false) }
        var minLines by remember { mutableIntStateOf(1) }
        var maxLines by remember { mutableIntStateOf(1) }
        var shape by remember { mutableStateOf(RectangleShape) }
        var clickedContents by remember { mutableStateOf("") }

        val contente = """
TextField(
    value = "${value}",
    enabled = ${enabled},
    readOnly = ${readOnly},
    label = ${label},
    placeholder = { Text(text = "${placeholder}") },
    leadingIcon = getLeadingIcon(leadingIcon),
    trailingIcon = getTrailingIcon(trailingIcon),
    prefix = { Text(text = "${prefix}") },
    suffix = { Text(text = "${suffix}") },
    supportingText = "${supportingText}",
    isError = ${isError},
    keyboardOptions = KeyboardOptions(capitalization = keyboardCapitalization, keyboardType = keyboardType,),
    singleLine = ${singleLine},
    minLines = ${minLines},
    maxLines = ${maxLines},
    shape = ${shape},
    )
                            """

        val labelCompose: @Composable (() -> Unit)? = if (label.isNotEmpty()) {
            { Text(text = label) }
        } else {
            null
        }


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
                leadingIcon = getLeadingIcon(leadingIcon),
                trailingIcon = getTrailingIcon(trailingIcon),
                prefix = { Text(text = prefix) },
                suffix = { Text(text = suffix) },
                supportingText = getSupportingText(supportingText),
                isError = isError,
                keyboardOptions = KeyboardOptions(
                    capitalization = keyboardCapitalization,
                    keyboardType = keyboardType,
                ),
                singleLine = singleLine,
                minLines = minLines,
                maxLines = maxLines,
                shape = shape,
                //visualTransformation = PasswordVisualTransformation(mask = '\u2023'),
            )
            Spacer(modifier = Modifier.height(10.dp))
            TabRow(selectedTabIndex = 0) {
                Tab(selected = true, onClick = {
                    navController.navigate("start") {
                        popUpTo(0)
                    }
                }) {
                    Text(text = "Function Mode")
                }
                Tab(selected = true, onClick = {
                    navController.navigate("displayMode") {
                        popUpTo(0)
                    }
                }) {
                    Text(text = "Display Mode")
                }
            }
            Box(modifier = Modifier) {
                NavHost(navController, startDestination = "start") {
                    composable("displayMode") {
                        Column(Modifier.verticalScroll(rememberScrollState())) {
                            WriteValue(value) { value = it }
                            SelectEanbled { enabled = it }
                            WriteLabel(label) { label = it }
                            WritePlaceholder(placeholder) { placeholder = it }
                            SelectLeadingIcon(leadingIcon) { leadingIcon = it }
                            SelectTrailingIcon(trailingIcon) { trailingIcon = it }
                            WritePrefix(prefix) { prefix = it }
                            WriteSuffix(suffix) { suffix = it }
                            WriteSupportingText(supportingText) { supportingText = it }
                            SelectIsError(isError) { isError = it }
                            SelectKeyboardCapitalization { keyboardCapitalization = it }
                            SelectKeyboardType { keyboardType = it }
                            SelectReadOnly { readOnly = it }
                            SelectShape { shape = it }
                            SelectMinLines(minLines) {
                                minLines = it.toInt(); if (minLines > maxLines) {
                                maxLines = minLines
                            }
                            }
                            SelectMaxLines(maxLines) {
                                maxLines = it.toInt(); if (minLines > maxLines) {
                                maxLines = minLines
                            }
                            }
                        }
                    }
                    composable("start") {
                        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                            HorizontalDivider()
                            Spacer(modifier = Modifier.height(10.dp))
                            ClickableText(
                                modifier = Modifier.horizontalScroll(rememberScrollState()),
                                style = TextStyle(fontSize = 18.sp),
                                text = AnnotatedString(contente),
                            ) {
                                var start = it - 10
                                var end = it + 20
                                if (it - 10 < 0) {
                                    start = 0
                                }
                                if (end + 20 > contente.length) {
                                    end = contente.length
                                }
                                clickedContents = contente.substring(start, end)
                                if (clickedContents.contains("value")) {
                                    navController.navigate("value")
                                } else if (clickedContents.contains("enabled")) {
                                    navController.navigate("enabled")
                                } else if (clickedContents.contains("label")) {
                                    navController.navigate("label")
                                } else if (clickedContents.contains("placeholder")) {
                                    navController.navigate("placeholder")
                                } else if (clickedContents.contains("leadingIcon")) {
                                    navController.navigate("leadingIcon")
                                } else if (clickedContents.contains("trailingIcon")) {
                                    navController.navigate("trailingIcon")
                                } else if (clickedContents.contains("prefix")) {
                                    navController.navigate("prefix")
                                } else if (clickedContents.contains("suffix")) {
                                    navController.navigate("suffix")
                                } else if (clickedContents.contains("supportingText")) {
                                    navController.navigate("supportingText")
                                } else if (clickedContents.contains("isError")) {
                                    navController.navigate("isError")
                                } else if (clickedContents.contains("keyboardOptions")) {
                                    navController.navigate("keyboardOptions")
                                } else if (clickedContents.contains("singleLine")) {
                                    navController.navigate("singleLine")
                                } else if (clickedContents.contains("minLines")) {
                                    navController.navigate("minLines")
                                } else if (clickedContents.contains("maxLines")) {
                                    navController.navigate("maxLines")
                                } else if (clickedContents.contains("shape")) {
                                    navController.navigate("shape")
                                }
                            }
                        }
                    }
                    composable("value") {
                        Column {
                            WriteValue(value) { value = it }
                        }
                    }
                    composable("enabled") {
                        Column {
                            SelectEanbled { enabled = it }
                        }
                    }
                    composable("label") {
                        Column {
                            WriteLabel(label) { label = it }
                        }
                    }
                    composable("placeholder") {
                        Column {
                            WritePlaceholder(placeholder) { placeholder = it }
                        }
                    }
                    composable("leadingIcon") {
                        Column {
                            SelectLeadingIcon(leadingIcon) { leadingIcon = it }
                        }
                    }
                    composable("trailingIcon") {
                        Column {
                            SelectTrailingIcon(trailingIcon) { trailingIcon = it }
                        }
                    }
                    composable("prefix") {
                        Column {
                            WritePrefix(prefix) { prefix = it }
                        }
                    }
                    composable("suffix") {
                        Column {
                            WriteSuffix(suffix) { suffix = it }
                        }
                    }
                    composable("supportingText") {
                        Column {
                            WriteSupportingText(supportingText) { supportingText = it }
                        }
                    }
                    composable("isError") {
                        Column {
                            SelectIsError(isError) { isError = it }
                        }
                    }
                    composable("keyboardOptions") {
                        Column {
                            SelectKeyboardCapitalization { keyboardCapitalization = it }
                            SelectKeyboardType { keyboardType = it }
                        }
                    }
                    composable("singleLine") {
                        Column {
                            SelectSingleLine { singleLine = it }
                        }
                    }
                    composable("shape") {
                        Column {
                            SelectShape { shape = it }
                        }
                    }
                    composable("minLines") {
                        Column {
                            SelectMinLines(minLines) {
                                minLines = it.toInt(); if (minLines > maxLines) {
                                maxLines = minLines
                            }
                            }
                        }
                    }
                    composable("maxLines") {
                        Column {
                            SelectMaxLines(maxLines) {
                                maxLines = it.toInt(); if (minLines > maxLines) {
                                maxLines = minLines
                            }
                            }
                        }
                    }
                }
            }
        }
    }
}