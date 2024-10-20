package com.sryang.textfield.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldCatalog(onClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .padding(end = 8.dp)
        ) {
            ProvideTextFieldWithDescription()
            IconButton(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .clip(CircleShape)
                    .background(Color.LightGray)
                    .size(40.dp),
                onClick = onClick
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "",
                )
            }
        }
        Spacer(Modifier.height(8.dp))
        DottedHorizontalDivider()
    }
}


@Composable
fun DottedHorizontalDivider(
    color: Color = MaterialTheme.colorScheme.onSurface,
    thickness: Dp = 1.dp,
    dashWidth: Float = 10f,
    gapWidth: Float = 10f
) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(thickness)
    ) {
        // 가로 점선 그리기
        drawLine(
            brush = Brush.linearGradient(
                colors = listOf(Color.Red, Color.Blue)
            ),
            start = androidx.compose.ui.geometry.Offset(0f, size.height / 2),
            end = androidx.compose.ui.geometry.Offset(size.width, size.height / 2),
            //paint = paint.asComposePaint(),
            strokeWidth = thickness.toPx(),
            pathEffect = PathEffect.dashPathEffect(
                intervals = floatArrayOf(dashWidth, gapWidth),
                phase = 0f
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun preview() {
    TextFieldCatalog { }
}
