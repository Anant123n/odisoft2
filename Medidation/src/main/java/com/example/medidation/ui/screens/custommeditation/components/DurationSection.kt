package com.example.medidation.ui.screens.custommeditation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medidation.ui.bodyMediumLeftStyle
import com.example.medidation.ui.captionSmallCenteredStyle
import com.example.medidation.ui.smallSubtitleLeftStyle
import com.example.medidation.ui.screens.custommeditation.Accent
import com.example.medidation.ui.screens.custommeditation.ChipBackground
import com.example.medidation.ui.screens.custommeditation.DurationOption
import com.example.medidation.ui.screens.custommeditation.PrimaryText
import com.example.medidation.ui.screens.custommeditation.SecondaryText
import com.example.medidation.ui.screens.homepage.components.HomepageAssetImage

@Composable
internal fun DurationSection(
    durationOptions: List<DurationOption>,
    selectedDurationMinutes: Int,
    onDurationMinutesChange: (Int) -> Unit,
    hasMeditatedBefore: Boolean?,
    onMeditatedBeforeChange: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            HomepageAssetImage(
                assetPath = "file:///android_asset/custom_meditation/timer_icon.svg",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "How long of the session today?",
                color = PrimaryText,
                style = bodyMediumLeftStyle().copy(
                    textAlign = TextAlign.Center
                )
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    text = selectedDurationMinutes.toString(),
                    color = PrimaryText,
                    style = TextStyle(
                        fontSize = 36.sp,
                        lineHeight = 43.sp,
                        color = PrimaryText,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = "min",
                    color = PrimaryText,
                    style = captionSmallCenteredStyle().copy(
                        fontWeight = FontWeight.Normal
                    ),
                    modifier = Modifier.padding(start = 4.dp, bottom = 5.dp)
                )
            }

            DurationSlider(
                selectedDurationMinutes = selectedDurationMinutes,
                minMinutes = 1,
                maxMinutes = 60,
                onDurationMinutesChange = onDurationMinutesChange
            )
        }

        DurationChipRow(
            durationOptions = durationOptions,
            selectedDurationMinutes = selectedDurationMinutes,
            onDurationMinutesChange = onDurationMinutesChange
        )
        MeditationExperienceCard(
            hasMeditatedBefore = hasMeditatedBefore,
            onMeditatedBeforeChange = onMeditatedBeforeChange
        )
    }
}

@Composable
private fun DurationSlider(
    selectedDurationMinutes: Int,
    minMinutes: Int,
    maxMinutes: Int,
    onDurationMinutesChange: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .align(Alignment.Center)
        ) {
            val totalSteps = maxMinutes - minMinutes
            val stepWidth = size.width / totalSteps
            
            // Draw a dot for each minute
            for (i in 0..totalSteps) {
                drawCircle(
                    color = SecondaryText.copy(alpha = 0.4f),
                    radius = 1.25.dp.toPx(),
                    center = Offset(i * stepWidth, size.height / 2)
                )
            }
        }

        Slider(
            value = selectedDurationMinutes.toFloat(),
            onValueChange = { onDurationMinutesChange(it.toInt().coerceIn(minMinutes, maxMinutes)) },
            valueRange = minMinutes.toFloat()..maxMinutes.toFloat(),
            steps = maxMinutes - minMinutes - 1,
            colors = SliderDefaults.colors(
                thumbColor = PrimaryText,
                activeTrackColor = Color.Transparent,
                inactiveTrackColor = Color.Transparent,
                activeTickColor = Color.Transparent,
                inactiveTickColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        )
    }
}

@Composable
private fun DurationChipRow(
    durationOptions: List<DurationOption>,
    selectedDurationMinutes: Int,
    onDurationMinutesChange: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        durationOptions.forEach { option ->
            val selected = option.minutes == selectedDurationMinutes
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(32.dp))
                    .background(if (selected) Accent else ChipBackground)
                    .clickable { onDurationMinutesChange(option.minutes) }
                    .padding(
                        horizontal = if (option.label.length > 4) 14.dp else 18.dp,
                        vertical = 10.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = option.label,
                    color = if (selected) Color(0xFF642D20) else PrimaryText,
                    style = smallSubtitleLeftStyle().copy(textAlign = TextAlign.Center)
                )
            }
        }
    }
}

@Composable
private fun MeditationExperienceCard(
    hasMeditatedBefore: Boolean?,
    onMeditatedBeforeChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White.copy(alpha = 0.08f))
            .border(1.dp, Color.White.copy(alpha = 0.50f), RoundedCornerShape(12.dp))
            .padding(horizontal = 12.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HomepageAssetImage(
            assetPath = "file:///android_asset/custom_meditation/meditation_experience_icon.svg",
            modifier = Modifier.size(40.dp),
            contentScale = ContentScale.Fit
        )

        Text(
            text = "Have you meditated before?",
            color = PrimaryText,
            style = bodyMediumLeftStyle(),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp, end = 8.dp)
        )

        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            ChoiceChip(
                text = "Yes",
                selected = hasMeditatedBefore == true,
                onClick = { onMeditatedBeforeChange(true) }
            )
            ChoiceChip(
                text = "No",
                selected = hasMeditatedBefore == false,
                onClick = { onMeditatedBeforeChange(false) }
            )
        }
    }
}

@Composable
private fun ChoiceChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .widthIn(min = 52.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(if (selected) Accent else ChipBackground)
            .clickable(onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (selected) Color(0xFF642D20) else PrimaryText,
            style = smallSubtitleLeftStyle().copy(textAlign = TextAlign.Center),
            maxLines = 1
        )
    }
}
