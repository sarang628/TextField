package com.sryang.textfield.compose.customtextfield

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicSecureTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.sryang.textfield.compose.getLeadingIcon
import com.sryang.textfield.compose.getSupportingText
import com.sryang.textfield.compose.getTrailingIcon
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class CustomTextFieldUiState(
    val textFieldType: String = "TextField", //TextField, BasicTextField
    val label: String = "",
    val prefix: String = "",
    val suffix: String = "",
    val value: String = "",
    val placeholder: String = "Search YouTube",
    val supportingText: String = "",
    val keyboardCapitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    val keyboardType: KeyboardType = KeyboardType.Text,
    val readOnly: Boolean = false,
    val enabled: Boolean = true,
    val singleLine: Boolean = false,
    val leadingIcon: Boolean = false,
    val trailingIcon: Boolean = false,
    val isError: Boolean = false,
    val minLines: Int = 1,
    val maxLines: Int = 1,
    val shape: Shape = RectangleShape,
    val clickedContents: String = "",
    val themeIndex: Int = 0,
    val mode: Int = 0,
    val height: Int = 50,
)

val CustomTextFieldUiState.content
    get() = """${textFieldType}(
    value = "${value}",
    enabled = ${enabled},
    modifier = Modifier.height(${height}.dp),
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


@HiltViewModel
class CustomTextFieldViewModel @Inject constructor() : ViewModel() {

    var uiState by mutableStateOf(CustomTextFieldUiState())
        private set

    fun setMode(i: Int) {
        uiState = uiState.copy(mode = i)
    }

    fun setValue(it: String) {
        uiState = uiState.copy(value = it)
    }

    fun setEnable(it: Boolean) {
        uiState = uiState.copy(enabled = it)
    }

    fun setLabel(it: String) {
        uiState = uiState.copy(label = it)
    }

    fun setPlaceHolder(it: String) {
        uiState = uiState.copy(placeholder = it)
    }

    fun setLeadingIcon(it: Boolean) {
        uiState = uiState.copy(leadingIcon = it)
    }

    fun setTrailingIcon(it: Boolean) {
        uiState = uiState.copy(trailingIcon = it)
    }

    fun setPrefix(it: String) {
        uiState = uiState.copy(prefix = it)
    }

    fun setSuffix(it: String) {
        uiState = uiState.copy(suffix = it)
    }

    fun setSupportingText(it: String) {
        uiState = uiState.copy(supportingText = it)
    }

    fun setIsError(it: Boolean) {
        uiState = uiState.copy(isError = it)
    }

    fun setKeyboardCapitalization(it: KeyboardCapitalization) {
        uiState = uiState.copy(keyboardCapitalization = it)
    }

    fun setKeyboardType(it: KeyboardType) {
        uiState = uiState.copy(keyboardType = it)
    }

    fun setReadOnly(it: Boolean) {
        uiState = uiState.copy(readOnly = it)
    }

    fun setShape(it: Shape) {
        uiState = uiState.copy(shape = it)
    }

    fun setMinLines(toInt: Int) {
        uiState = uiState.copy(minLines = toInt)
    }

    fun setMaxLines(minLines: Int) {
        uiState = uiState.copy(minLines = minLines)
    }

    fun setThemeIndex(it: Int) {
        uiState = uiState.copy(themeIndex = it)
    }

    fun setClickedContents(substring: String) {
        uiState = uiState.copy(clickedContents = substring)
    }

    fun setSingleLine(it: Boolean) {
        uiState = uiState.copy(singleLine = it)
    }

    fun setHeight(toInt: Int) {
        uiState = uiState.copy(height = toInt)
    }

    fun setTextFieldType(it: String) {
        uiState = uiState.copy(textFieldType = it)
    }
}