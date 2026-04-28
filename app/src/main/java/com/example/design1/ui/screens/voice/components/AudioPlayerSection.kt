package com.example.design1.ui.screens.voice.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.design1.R
import com.example.design1.ui.bigSubtitleLeftStyle
import com.example.design1.ui.captionSmallLeftStyle

@Composable
internal fun AudioPlayerSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Track Info and Transcribing
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(100.dp))
                    .background(Color(0x1AFFFFFF))
                    .padding(start = 20.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            "The week beneath the week",
                            color = Color(0xFFF2EBE9),
                            style = captionSmallLeftStyle()
                        )
                        Text(
                            "00:00:00 - 03:23:11",
                            color = Color(0xFFB6B0AF),
                            style = captionSmallLeftStyle()
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.ic_plus),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(100.dp))
                    .background(Color(0xFFD66C4A))
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(
                    "Transcribing",
                    color = Color(0xFF171312),
                    style = captionSmallLeftStyle()
                )
            }
        }

        // Progress Bar
        Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    // Visualization bars
                    repeat(9) { index ->
                        Box(
                            modifier = Modifier
                                .weight(if (index == 0) 0.15f else if (index == 3) 0.13f else if (index == 6) 0.12f else if (index == 8) 0.17f else 0.1f)
                                .fillMaxHeight()
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color(0x1AFFFFFF))
                        )
                    }
                }
                // Thumb
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFFE370C))
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("0:00", color = Color(0xFFF2EBE9), style = captionSmallLeftStyle())
                Text("10:19", color = Color(0xFFF2EBE9), style = captionSmallLeftStyle())
            }
        }

        // Controls
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.entry_gallery_icon),
                contentDescription = null,
                modifier = Modifier.size(36.dp)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.back_button),
                        contentDescription = null,
                        modifier = Modifier.size(35.dp)
                    )
                    Text("30 sec", color = Color(0xFFB6B0AF), style = captionSmallLeftStyle())
                }

                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFFE6847)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.play_button_1),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.back_button),
                        contentDescription = null,
                        modifier = Modifier.size(35.dp)
                    )
                    Text("30 sec", color = Color(0xFFB6B0AF), style = captionSmallLeftStyle())
                }
            }

            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color(0x1AFFFFFF)),
                contentAlignment = Alignment.Center
            ) {
                Text("1x", color = Color(0xFFF2EBE9), style = bigSubtitleLeftStyle().copy(fontSize = 14.sp))
            }
        }

        // Home Indicator
        Image(
            painter = painterResource(id = R.drawable.home_indicator),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(21.dp)
        )
    }
}
