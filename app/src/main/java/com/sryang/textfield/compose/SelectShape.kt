package com.sryang.textfield.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun SelectShape(
    onChange: (Shape) -> Unit = {},
) {
    Column {
        Chips(
            "KeyboardType",
            "RectangleShape",
            "CircleShape",
            "RoundedCornerShape",
            "CutCornerShape",
        ) {
            // @formatter:off
            when(it){
                "CircleShape" -> onChange.invoke(CircleShape)
                "RoundedCornerShape" -> onChange.invoke(RoundedCornerShape(200.dp))
                "CutCornerShape" -> onChange.invoke(CutCornerShape(8.dp))
                "RectangleShape" -> onChange.invoke(RectangleShape)
            }
            // @formatter:on
        }
    }
}