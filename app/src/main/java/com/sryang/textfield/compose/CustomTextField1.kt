package com.sryang.textfield.compose

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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sryang.library.themeTypeList

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
    var themeIndex by remember { mutableIntStateOf(0) }
    var mode by remember { mutableIntStateOf(0) }

    AnnotatedString("")

    val contents = """TextField(
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
    shape = ${shape}
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
        themeTypeList[themeIndex].contents {
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
                shape = shape
                //visualTransformation = PasswordVisualTransformation(mask = '\u2023'),
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        TabRow(selectedTabIndex = mode) {
            Tab(
                modifier = Modifier.height(40.dp),
                selected = mode == 0, onClick = {
                    mode = 0
                    navController.navigate("start") {
                        popUpTo(0)
                    }
                }) {
                Text(text = "Function Mode")
            }
            Tab(selected = mode == 1, onClick = {
                mode = 1
                navController.navigate("displayMode") {
                    popUpTo(0)
                }
            }) {
                Text(text = "Display Mode")
            }
        }
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
                    SelectTheme { themeIndex = it }
                }
            }
            composable("start") {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    HorizontalDivider()
                    Spacer(modifier = Modifier.height(10.dp))
                    ClickableText(
                        modifier = Modifier.horizontalScroll(rememberScrollState()),
                        style = TextStyle(fontSize = 18.sp),
                        text = buildAnnotatedString {
                            append(contents)
                        },
                    ) {
                        var start = it - 10
                        var end = it + 20
                        if (it - 10 < 0) {
                            start = 0
                        }
                        if (end + 20 > contents.length) {
                            end = contents.length
                        }
                        clickedContents = contents.substring(start, end)

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
                        } else if (clickedContents.contains("readOnly")) {
                            navController.navigate("readOnly")
                        } else if (clickedContents.contains("colors")) {
                            navController.navigate("colors")
                        }
                    }
                    SelectTheme { themeIndex = it }
                }
            }
            composable("value") { WriteValue(value) { value = it } }
            composable("enabled") { SelectEanbled { enabled = it } }
            composable("label") { WriteLabel(label) { label = it } }
            composable("placeholder") { WritePlaceholder(placeholder) { placeholder = it } }
            composable("leadingIcon") { SelectLeadingIcon(leadingIcon) { leadingIcon = it } }
            composable("trailingIcon") { SelectTrailingIcon(trailingIcon) { trailingIcon = it } }
            composable("prefix") { WritePrefix(prefix) { prefix = it } }
            composable("suffix") { WriteSuffix(suffix) { suffix = it } }
            composable("supportingText") {
                WriteSupportingText(supportingText) {
                    supportingText = it
                }
            }
            composable("isError") { SelectIsError(isError) { isError = it } }
            composable("keyboardOptions") {
                Column {
                    SelectKeyboardCapitalization { keyboardCapitalization = it }
                    SelectKeyboardType { keyboardType = it }
                }
            }
            composable("singleLine") { SelectSingleLine { singleLine = it } }
            composable("shape") { SelectShape { shape = it } }
            composable("minLines") {
                SelectMinLines(minLines) {
                    minLines = it.toInt(); if (minLines > maxLines) {
                    maxLines = minLines
                }
                }
            }
            composable("maxLines") {
                SelectMaxLines(maxLines) {
                    maxLines = it.toInt(); if (minLines > maxLines) {
                    maxLines = minLines
                }
                }
            }
            composable("readOnly") {
                SelectReadOnly {
                    readOnly = it
                }
            }
            composable("colors") {
                Button(onClick = { /*TODO*/ }) {

                }
            }
        }
    }
}

@Composable
fun SelectTheme(onClick: (Int) -> Unit) {
    Chips(
        title = "Themes",
        themeTypeList[0].name,
        themeTypeList[1].name,
        themeTypeList[2].name,
        themeTypeList[3].name,
        themeTypeList[4].name,
        themeTypeList[5].name,
        themeTypeList[6].name,
        themeTypeList[7].name,
    ) {
        when (it) {
            themeTypeList[0].name -> {
                onClick.invoke(0)
            }
            themeTypeList[1].name -> {
                onClick.invoke(1)
            }
            themeTypeList[2].name -> {
                onClick.invoke(2)
            }
            themeTypeList[3].name -> {
                onClick.invoke(3)
            }
            themeTypeList[4].name -> {
                onClick.invoke(4)
            }
            themeTypeList[5].name -> {
                onClick.invoke(5)
            }
            themeTypeList[6].name -> {
                onClick.invoke(6)
            }
            themeTypeList[7].name -> {
                onClick.invoke(7)
            }
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