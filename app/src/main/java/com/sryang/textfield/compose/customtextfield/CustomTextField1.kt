package com.sryang.textfield.compose.customtextfield

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicSecureTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sryang.library.ThemeProvider
import com.sryang.library.Youtube
import com.sryang.library.themeTypeList
import com.sryang.textfield.compose.SelectEanbled
import com.sryang.textfield.compose.SelectIsError
import com.sryang.textfield.compose.SelectKeyboardCapitalization
import com.sryang.textfield.compose.SelectKeyboardType
import com.sryang.textfield.compose.SelectLeadingIcon
import com.sryang.textfield.compose.SelectMaxLines
import com.sryang.textfield.compose.SelectMinLines
import com.sryang.textfield.compose.SelectModifier
import com.sryang.textfield.compose.SelectReadOnly
import com.sryang.textfield.compose.SelectShape
import com.sryang.textfield.compose.SelectSingleLine
import com.sryang.textfield.compose.SelectTextFieldType
import com.sryang.textfield.compose.SelectTheme
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

@Composable
fun CustomTextField1(
    viewModel: CustomTextFieldViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    val uiState = viewModel.uiState

    AnnotatedString("")


    Column {
        HorizontalDivider()
        Spacer(modifier = Modifier.height(10.dp))
        themeTypeList[uiState.themeIndex].contents {
            uiState.TextField { viewModel.setValue(it) }
        }
        Spacer(modifier = Modifier.height(10.dp))
        TabRow(selectedTabIndex = uiState.mode) {
            Tab(
                modifier = Modifier.height(40.dp),
                selected = uiState.mode == 0, onClick = {
                    viewModel.setMode(0)
                    navController.navigate("start") {
                        popUpTo(0)
                    }
                }) {
                Text(text = "Function Mode")
            }
            Tab(selected = uiState.mode == 1, onClick = {
                viewModel.setMode(1)
                navController.navigate("displayMode") {
                    popUpTo(0)
                }
            }) {
                Text(text = "Display Mode")
            }
        }
        TextFieldManipulateNav(navController = navController, viewModel = viewModel)
    }
}

@Composable
fun TextFieldManipulateNav(navController: NavHostController, viewModel: CustomTextFieldViewModel) {
    val uiState = viewModel.uiState
    val contents = uiState.content
    NavHost(navController, startDestination = "start") {
        composable("displayMode") {
            Column(Modifier.verticalScroll(rememberScrollState())) {
                WriteValue(uiState.value) { viewModel.setValue(it) }
                SelectEanbled { viewModel.setEnable(it) }
                WriteLabel(uiState.label) { viewModel.setLabel(it) }
                WritePlaceholder(uiState.placeholder) { viewModel.setPlaceHolder(it) }
                SelectLeadingIcon(uiState.leadingIcon) { viewModel.setLeadingIcon(it) }
                SelectTrailingIcon(uiState.trailingIcon) { viewModel.setTrailingIcon(it) }
                WritePrefix(uiState.prefix) { viewModel.setPrefix(it) }
                WriteSuffix(uiState.suffix) { viewModel.setSuffix(it) }
                WriteSupportingText(uiState.supportingText) { viewModel.setSupportingText(it) }
                SelectIsError(uiState.isError) { viewModel.setIsError(it) }
                SelectKeyboardCapitalization { viewModel.setKeyboardCapitalization(it) }
                SelectKeyboardType { viewModel.setKeyboardType(it) }
                SelectReadOnly { viewModel.setReadOnly(it) }
                SelectShape { viewModel.setShape(it) }
                SelectMinLines(uiState.minLines) {
                    viewModel.setMinLines(it.toInt()); if (uiState.minLines > uiState.maxLines) {
                    viewModel.setMaxLines(uiState.minLines)
                }
                }
                SelectMaxLines(uiState.maxLines) {
                    viewModel.setMaxLines(it.toInt()); if (uiState.minLines > uiState.maxLines) {
                    viewModel.setMaxLines(uiState.minLines)
                }
                }
                SelectTheme { viewModel.setThemeIndex(it) }
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
                    val clickContents = contents.substring(start, end)
                    viewModel.setClickedContents(clickContents)

                    if (clickContents.contains("TextField")) {
                        navController.navigate("textField")
                    } else if (clickContents.contains("value")) {
                        navController.navigate("value")
                    } else if (clickContents.contains("enabled")) {
                        navController.navigate("enabled")
                    } else if (clickContents.contains("label")) {
                        navController.navigate("label")
                    } else if (clickContents.contains("placeholder")) {
                        navController.navigate("placeholder")
                    } else if (clickContents.contains("leadingIcon")) {
                        navController.navigate("leadingIcon")
                    } else if (clickContents.contains("trailingIcon")) {
                        navController.navigate("trailingIcon")
                    } else if (clickContents.contains("prefix")) {
                        navController.navigate("prefix")
                    } else if (clickContents.contains("suffix")) {
                        navController.navigate("suffix")
                    } else if (clickContents.contains("supportingText")) {
                        navController.navigate("supportingText")
                    } else if (clickContents.contains("isError")) {
                        navController.navigate("isError")
                    } else if (clickContents.contains("keyboardOptions")) {
                        navController.navigate("keyboardOptions")
                    } else if (clickContents.contains("singleLine")) {
                        navController.navigate("singleLine")
                    } else if (clickContents.contains("minLines")) {
                        navController.navigate("minLines")
                    } else if (clickContents.contains("maxLines")) {
                        navController.navigate("maxLines")
                    } else if (clickContents.contains("shape")) {
                        navController.navigate("shape")
                    } else if (clickContents.contains("readOnly")) {
                        navController.navigate("readOnly")
                    } else if (clickContents.contains("colors")) {
                        navController.navigate("colors")
                    } else if (clickContents.contains("modifier")) {
                        navController.navigate("modifier")
                    }
                }
                SelectTheme { viewModel.setThemeIndex(it) }
            }
        }
        composable("textField") { SelectTextFieldType { viewModel.setTextFieldType(it) } }
        composable("value") { WriteValue(uiState.value) { viewModel.setValue(it) } }
        composable("enabled") { SelectEanbled { viewModel.setEnable(it) } }
        composable("label") { WriteLabel(uiState.label) { viewModel.setLabel(it) } }
        composable("placeholder") {
            WritePlaceholder(uiState.placeholder) {
                viewModel.setPlaceHolder(
                    it
                )
            }
        }
        composable("leadingIcon") {
            SelectLeadingIcon(uiState.leadingIcon) {
                viewModel.setLeadingIcon(
                    it
                )
            }
        }
        composable("trailingIcon") {
            SelectTrailingIcon(uiState.trailingIcon) {
                viewModel.setTrailingIcon(
                    it
                )
            }
        }
        composable("prefix") { WritePrefix(uiState.prefix) { viewModel.setPrefix(it) } }
        composable("suffix") { WriteSuffix(uiState.suffix) { viewModel.setSuffix(it) } }
        composable("supportingText") {
            WriteSupportingText(uiState.supportingText) {
                viewModel.setSupportingText(it)
            }
        }
        composable("isError") { SelectIsError(uiState.isError) { viewModel.setIsError(it) } }
        composable("keyboardOptions") {
            Column {
                SelectKeyboardCapitalization { viewModel.setKeyboardCapitalization(it) }
                SelectKeyboardType { viewModel.setKeyboardType(it) }
            }
        }
        composable("singleLine") { SelectSingleLine { viewModel.setSingleLine(it) } }
        composable("shape") { SelectShape { viewModel.setShape(it) } }
        composable("minLines") {
            SelectMinLines(uiState.minLines) {
                viewModel.setMinLines(it.toInt()); if (uiState.minLines > uiState.maxLines) {
                viewModel.setMaxLines(uiState.minLines)
            }
            }
        }
        composable("maxLines") {
            SelectMaxLines(uiState.maxLines) {
                viewModel.setMaxLines(it.toInt()); if (uiState.minLines > uiState.maxLines) {
                viewModel.setMaxLines(uiState.minLines)
            }
            }
        }
        composable("readOnly") {
            SelectReadOnly {
                viewModel.setReadOnly(it)
            }
        }
        composable("colors") {
            Button(onClick = { }) {

            }
        }
        composable("modifier") {
            SelectModifier(height = uiState.height) {
                viewModel.setHeight(it.toInt())
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
            CustomTextField1(navController = navController)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CustomTextFieldUiState.TextField(onValueChange: (String) -> Unit) {

    val labelCompose: @Composable (() -> Unit)? = if (label.isNotEmpty()) {
        { Text(text = label) }
    } else {
        null
    }

    if (textFieldType == "TextField") {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth()
            ,
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
    } else if (textFieldType == "OutlinedTextField") {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(height.dp),
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
        )
    } else if (textFieldType == "BasicSecureTextField") {
        BasicSecureTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(height.dp),
            enabled = enabled,
        )
    } else if (textFieldType == "BasicTextField") {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth(),
            enabled = enabled,
            readOnly = readOnly,
            keyboardOptions = KeyboardOptions(
                capitalization = keyboardCapitalization,
                keyboardType = keyboardType,
            ),
            textStyle = TextStyle(color = MaterialTheme.colorScheme.onSurfaceVariant),
            minLines = minLines,
            maxLines = maxLines,
            decorationBox = {
                Box(
                    modifier = Modifier
                        .height(height.dp)
                        .clip(shape)
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .padding(start = 16.dp, end = 16.dp),
                    contentAlignment = Alignment.CenterStart
                )
                {
                    if (value.isNotEmpty())
                        it.invoke()
                    else{
                        Text(text = placeholder, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }
        )
    } else if (textFieldType == "BasicTextField2") {
        BasicTextField2(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(height.dp),
            enabled = enabled,
            readOnly = readOnly,
            keyboardOptions = KeyboardOptions(
                capitalization = keyboardCapitalization,
                keyboardType = keyboardType,
            )
        )
    }
}