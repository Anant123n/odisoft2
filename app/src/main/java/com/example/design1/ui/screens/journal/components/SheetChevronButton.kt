package com.example.design1.ui.screens.journal.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

@Composable
internal fun SheetChevronButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(Color(0x1AFFFFFF)),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(18.dp)) {
            val color = Color(0xFFF2EBE9)
            val y = size.height * 0.42f
            val left = Offset(size.width * 0.22f, y)
            val mid = Offset(size.width * 0.50f, size.height * 0.68f)
            val right = Offset(size.width * 0.78f, y)
            drawLine(color = color, start = left, end = mid, strokeWidth = 2.2f, cap = StrokeCap.Round)
            drawLine(color = color, start = mid, end = right, strokeWidth = 2.2f, cap = StrokeCap.Round)
        }
    }
}

