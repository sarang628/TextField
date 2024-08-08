package com.sryang.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sryang.textfield.compose.customtextfield.CustomTextField
import com.sryang.textfield.ui.theme.KeyboardOptionsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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