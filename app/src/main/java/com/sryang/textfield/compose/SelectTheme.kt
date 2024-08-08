package com.sryang.textfield.compose

import androidx.compose.runtime.Composable
import com.sryang.library.themeTypeList

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