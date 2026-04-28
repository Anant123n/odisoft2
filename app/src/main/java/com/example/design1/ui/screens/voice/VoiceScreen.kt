package com.example.design1.ui.screens.voice

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.design1.R
import com.example.design1.ui.bigSubtitleLeftStyle
import com.example.design1.ui.captionSmallLeftStyle
import com.example.design1.ui.robotoTimeStyle
import com.example.design1.ui.smallTitleStyle

@Composable
internal fun VoiceScreen(onBack: () -> Unit) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF423C3A), Color(0xFF171312))
                )
            )
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
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
                    // Using a chevron/back icon. Since ic_voice_back failed, I'll use back_button if it exists or a simple image
                    Image(
                        painter = painterResource(id = R.drawable.back_button),
                        contentDescription = "Back",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            // Chat Messages
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(scrollState)
                    .padding(horizontal = 16.dp, vertical = 32.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                VoiceMessage(
                    sender = "Milo",
                    text = "Analysis complete! It looks like you might be dealing with some hidden anxieties. Have you had any anxiety recently? And do you remember the events that triggered them? Maybe try art therapy or dream journaling?",
                    avatarRes = R.drawable.avatar_left_463f98
                )

                VoiceMessage(
                    sender = "Soma",
                    text = "Analysis complete! It looks like you might be dealing with some hidden anxieties. Have you had any anxiety recently? And do you remember the events that triggered them? Maybe try art therapy or dream journaling?",
                    avatarRes = R.drawable.avatar_right_49fcaf,
                    highlightText = "Analysis complete! It looks like you might be dealing with some hidden anxieties."
                )
            }

            // Footer / Audio Player
            AudioPlayerSection()
        }
    }
}

@Composable
private fun VoiceMessage(
    sender: String,
    text: String,
    avatarRes: Int,
    highlightText: String? = null
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Image(
            painter = painterResource(id = avatarRes),
            contentDescription = null,
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
        )

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Transparent)
                .padding(horizontal = 12.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    sender,
                    color = Color(0xFFF2EBE9).copy(alpha = 0.3f),
                    style = bigSubtitleLeftStyle().copy(fontSize = 17.sp)
                )
                
                val annotatedText = buildAnnotatedString {
                    if (highlightText != null && text.contains(highlightText)) {
                        val parts = text.split(highlightText)
                        withStyle(style = SpanStyle(color = Color(0xFFFE937B))) {
                            append(highlightText)
                        }
                        append(parts.getOrElse(1) { "" })
                    } else {
                        append(text)
                    }
                }
                
                Text(
                    text = annotatedText,
                    color = Color(0xFFF2EBE9),
                    style = smallTitleStyle().copy(fontSize = 20.sp, lineHeight = 26.sp)
                )
            }
        }
    }
}

@Composable
private fun AudioPlayerSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, bottom = 24.dp),
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
                        painter = painterResource(id = R.drawable.ic_plus), // Placeholder for down arrow
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
                painter = painterResource(id = R.drawable.entry_gallery_icon), // Placeholder for music icon
                contentDescription = null,
                modifier = Modifier.size(36.dp)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.back_button), // Placeholder
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
                        painter = painterResource(id = R.drawable.back_button), // Placeholder
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
