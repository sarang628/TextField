package com.sryang.textfield.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TextFieldNavigation() {
    val navController = rememberNavController()
    var title by remember { mutableStateOf("Hello Textfield World!") }

    // 현재 페이지를 감지하는 LaunchedEffect
    LaunchedEffect(navController) {
        snapshotFlow { navController.currentBackStackEntry }
            .collectLatest { backStackEntry ->
                title = backStackEntry?.destination?.route.toString()
            }
    }


    Scaffold(
        contentWindowInsets = WindowInsets(12.dp),
        topBar = {
            TopAppBar(title = {
                Text(title)
            })
        }
    ) {
        Box(Modifier.padding(it)) {
            NavHost(navController, startDestination = "TextFieldCatalog") {
                composable("TextFieldCatalog") {
                    TextFieldCatalog {
                        navController.navigate("TextFieldWithDescription")
                    }
                }
                composable("TextFieldWithDescription") {
                    TextFieldWithDescription()
                }
            }
        }
    }
}