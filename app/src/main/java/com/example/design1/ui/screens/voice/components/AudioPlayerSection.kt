package com.example.design1.ui.screens.voice.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import com.example.design1.R
import com.example.design1.ui.captionSmallLeftStyle

@Composable
internal fun AudioPlayerSection(
    isTranscribing: Boolean,
    onToggleTranscription: () -> Unit
) {
    val playbackSpeeds = listOf("1x", "0.5x", "1.5x", "2x")
    var playbackSpeedIndex by remember { mutableIntStateOf(0) }
    val context = LocalContext.current
    val svgImageLoader = remember(context) {
        ImageLoader.Builder(context)
            .components {
                add(SvgDecoder.Factory())
            }
            .build()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Track Info and Transcribing Badge
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Track Info Box
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(Color(0x1AFFFFFF))
                    .padding(horizontal = 20.dp, vertical = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .height(32.dp),
                    verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterVertically)
                ) {
                    Text(
                        "The week beneath the week",
                        color = Color(0xFFF2EBE9),
                        style = captionSmallLeftStyle().copy(
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            lineHeight = 15.6.sp, // 130%
                            letterSpacing = 0.12.sp
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        "00:00:00 - 03:23:11",
                        color = Color(0xFFB6B0AF),
                        style = captionSmallLeftStyle().copy(
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            lineHeight = 15.6.sp, // 130%
                            letterSpacing = 0.12.sp
                        )
                    )
                }
            }

            // Transcribing Badge
            Box(
                modifier = Modifier
                    .widthIn(min = 96.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(if (isTranscribing) Color(0xFFD96C4A) else Color(0x1AFFFFFF))
                    .clickable { onToggleTranscription() }
                    .padding(horizontal = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    if (isTranscribing) "Transcribing" else "Transcribe",
                    color = if (isTranscribing) Color(0xFF171312) else Color(0xFFF2EBE9),
                    style = captionSmallLeftStyle().copy(
                        fontWeight = FontWeight.Medium,
                        letterSpacing = 0.12.sp
                    ),
                    maxLines = 1
                )
            }
        }

        // Progress Section
        Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
            // Segmented Progress Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    val segments = listOf(61f, 21f, 21f, 56f, 21f, 21f, 51f, 21f, 73f)
                    segments.forEach { weight ->
                        Box(
                            modifier = Modifier
                                .weight(weight)
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
                        .clip(CircleShape)
                        .background(Color(0xFFFE370C))
                        .border(4.dp, Color(0x1AFFFFFF), CircleShape)
                )
            }
            
            // Time Labels
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "0:00",
                    color = Color(0xFFF2EBE9),
                    style = captionSmallLeftStyle().copy(letterSpacing = 0.12.sp)
                )
                Text(
                    "10:19",
                    color = Color(0xFFF2EBE9),
                    style = captionSmallLeftStyle().copy(letterSpacing = 0.12.sp)
                )
            }
        }

        // Toolbar Controls
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Music Note Button
            AudioToolbarSvgIcon(
                imageLoader = svgImageLoader,
                assetPath = "file:///android_asset/audio_player/music_button.svg",
                contentDescription = "Music",
                modifier = Modifier.size(36.dp)
            )

            // Playback Controls
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Rewind 30s
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    AudioToolbarSvgIcon(
                        imageLoader = svgImageLoader,
                        assetPath = "file:///android_asset/audio_player/rewind_30.svg",
                        contentDescription = "Rewind 30s",
                        modifier = Modifier.size(35.dp)
                    )
                    Text(
                        "30 sec",
                        color = Color(0xFFB6B0AF),
                        style = captionSmallLeftStyle().copy(fontSize = 12.sp)
                    )
                }

                // Play Button
                AudioToolbarSvgIcon(
                    imageLoader = svgImageLoader,
                    assetPath = "file:///android_asset/audio_player/play_button.svg",
                    contentDescription = "Play",
                    modifier = Modifier.size(56.dp)
                )

                // Forward 30s
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    AudioToolbarSvgIcon(
                        imageLoader = svgImageLoader,
                        assetPath = "file:///android_asset/audio_player/forward_30.svg",
                        contentDescription = "Forward 30s",
                        modifier = Modifier.size(35.dp)
                    )
                    Text(
                        "30 sec",
                        color = Color(0xFFB6B0AF),
                        style = captionSmallLeftStyle().copy(fontSize = 12.sp)
                    )
                }
            }

            // Playback Speed Button
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color(0x1AFFFFFF))
                    .clickable {
                        playbackSpeedIndex = (playbackSpeedIndex + 1) % playbackSpeeds.size
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    playbackSpeeds[playbackSpeedIndex],
                    color = Color(0xFFF2EBE9),
                    style = captionSmallLeftStyle().copy(
                        fontWeight = FontWeight.Medium,
                        fontSize = 11.sp,
                        lineHeight = 14.sp
                    )
                )
            }
        }

        // Home Indicator
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(21.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .width(139.dp)
                    .height(5.dp)
                    .clip(RoundedCornerShape(40.dp))
                    .background(Color(0xFFF2EBE9))
            )
        }
    }
}

@Composable
private fun AudioToolbarSvgIcon(
    imageLoader: ImageLoader,
    assetPath: String,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = assetPath,
        imageLoader = imageLoader,
        contentDescription = contentDescription,
        modifier = modifier
    )
}
