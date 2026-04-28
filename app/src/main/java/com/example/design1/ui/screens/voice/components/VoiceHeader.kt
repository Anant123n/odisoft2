package com.example.design1.ui.screens.voice.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.design1.R
import com.example.design1.ui.robotoTimeStyle

@Composable
internal fun VoiceHeader(onBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        // Status Bar Area
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .padding(horizontal = 24.dp)
        ) {
            Text(
                "9:30",
                color = Color(0xFFA29C9A),
                style = robotoTimeStyle(),
                modifier = Modifier.align(Alignment.CenterStart)
            )
            Image(
                painter = painterResource(id = R.drawable.status_icons),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(width = 46.dp, height = 17.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.camera_cutout),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .size(24.dp)
            )
        }

        // Header with Back Button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color(0x1AFFFFFF))
                    .clickable { onBack() },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back_button),
                    contentDescription = "Back",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}
