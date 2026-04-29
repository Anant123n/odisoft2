package com.example.design1.ui.screens.podcast.settings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.design1.ui.bodyMediumLeftStyle
import com.example.design1.ui.bodySmallLeftStyle
import com.example.design1.ui.screens.podcast.settings.SettingsSliderItem

@Composable
internal fun PodcastStyleSection(
    items: List<SettingsSliderItem>,
    sliderPositions: Map<String, Float>,
    onSliderChange: (String, Float) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items.forEach { item ->
            val sliderValue = sliderPositions[item.id] ?: item.defaultPosition
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    item.title,
                    color = Color(0xFFF2EBE9),
                    style = bodyMediumLeftStyle().copy(
                        fontWeight = FontWeight.Normal,
                        letterSpacing = 0.16.sp
                    )
                )
                Text(
                    item.subtitle,
                    color = Color(0xFFB6B0AF),
                    style = bodySmallLeftStyle()
                )
                Spacer(modifier = Modifier.height(8.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0x1AFFFFFF))
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    BoxWithConstraints(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                    ) {
                        val thumbDiameter = 20.dp
                        val density = LocalDensity.current
                        val draggableWidth = maxWidth - thumbDiameter
                        val draggableWidthPx = with(density) { draggableWidth.toPx() }.coerceAtLeast(1f)
                        val thumbOffset = draggableWidth * sliderValue.coerceIn(0f, 1f)

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(4.dp)
                                .align(Alignment.Center)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFFFE370C).copy(alpha = 0.38f))
                                .pointerInput(item.id) {
                                    detectTapGestures { offset ->
                                        onSliderChange(
                                            item.id,
                                            (offset.x / draggableWidthPx).coerceIn(0f, 1f)
                                        )
                                    }
                                }
                        )

                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .size(6.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFF2EBE9))
                        )

                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .size(6.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFF2EBE9))
                        )

                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .offset(x = thumbOffset)
                                .size(20.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFFF5B30))
                                .draggable(
                                    orientation = Orientation.Horizontal,
                                    state = rememberDraggableState { delta ->
                                        onSliderChange(
                                            item.id,
                                            (sliderValue + (delta / draggableWidthPx)).coerceIn(0f, 1f)
                                        )
                                    }
                                )
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        item.labels.forEachIndexed { index, label ->
                            val alignment = when (index) {
                                0 -> Alignment.Start
                                item.labels.lastIndex -> Alignment.End
                                else -> Alignment.CenterHorizontally
                            }

                            Column(
                                modifier = Modifier.weight(1f),
                                horizontalAlignment = alignment
                            ) {
                                Text(
                                    label,
                                    color = Color(0xFFF2EBE9),
                                    style = bodySmallLeftStyle().copy(
                                        fontSize = 12.sp,
                                        lineHeight = 20.sp,
                                        fontWeight = FontWeight.Normal,
                                        letterSpacing = 0.48.sp
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
