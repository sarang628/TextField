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
import com.sryang.textfield.compose.CustomTextField
import com.sryang.textfield.compose.CustomTextField1
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
}