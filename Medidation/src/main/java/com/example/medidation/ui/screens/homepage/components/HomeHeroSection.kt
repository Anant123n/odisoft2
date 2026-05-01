package com.example.medidation.ui.screens.homepage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medidation.ui.bodyMediumLeftStyle
import com.example.medidation.ui.captionSmallCenteredStyle
import com.example.medidation.ui.smallSubtitleLeftStyle
import com.example.medidation.ui.screens.homepage.PromptCardUi

@Composable
internal fun HomeHeroSection(
    modifier: Modifier = Modifier,
    cards: List<PromptCardUi>
) {
    BoxWithConstraints(
        modifier = modifier
            .height(596.dp)
            .padding(top = 10.dp)
    ) {
        HomepageAssetImage(
            assetPath = "file:///android_asset/homepage/cloud.png",
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 16.dp)
                .size(width = 168.dp, height = 112.dp)
                .graphicsLayer(scaleY = -1f),
            contentScale = ContentScale.Crop,
            alpha = 0.46f
        )
        HomepageAssetImage(
            assetPath = "file:///android_asset/homepage/cloud.png",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 112.dp)
                .size(width = 198.dp, height = 132.dp)
                .graphicsLayer(scaleY = -1f),
            contentScale = ContentScale.Fit,
            alpha = 0.58f
        )
        HomepageAssetImage(
            assetPath = "file:///android_asset/homepage/cloud.png",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(x = 0.dp, y = 50.dp)
                .size(width = 134.dp, height = 88.dp)
                .graphicsLayer(scaleX = -1f, scaleY = -1f),
            contentScale = ContentScale.Crop,
            alpha = 0.44f
        )

        UltradianChip(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 12.dp, end = 18.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 26.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            HomepageAssetImage(
                assetPath = "file:///android_asset/homepage/hero_giraffe.png",
                modifier = Modifier.size(width = 156.dp, height = 186.dp),
                contentScale = ContentScale.Crop
            )

            BoxWithConstraints(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                val availableCardWidth = maxWidth - 32.dp
                val stackWidth = if (availableCardWidth < 324.dp) availableCardWidth else 324.dp

                Column(
                    modifier = Modifier.width(stackWidth),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    cards.forEach { card ->
                        PromptCard(
                            card = card,
                            availableWidth = availableCardWidth,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun PromptCard(
    card: PromptCardUi,
    availableWidth: androidx.compose.ui.unit.Dp,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(12.dp)
    val desiredWidth = card.width + 12.dp
    val effectiveWidth = if (desiredWidth < availableWidth) desiredWidth else availableWidth

    Column(
        modifier = modifier
            .width(effectiveWidth)
            .defaultMinSize(minHeight = card.height)
            .graphicsLayer(rotationZ = card.rotation)
            .clip(shape)
            .background(Color.White.copy(alpha = 0.10f))
            .drawBehind {
                drawRoundRect(
                    color = Color.White.copy(alpha = 0.10f),
                    style = Stroke(
                        width = 1.dp.toPx(),
                        pathEffect = PathEffect.dashPathEffect(
                            intervals = floatArrayOf(10f, 8f)
                        )
                    ),
                    cornerRadius = CornerRadius(12.dp.toPx(), 12.dp.toPx())
                )
            }
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = card.title,
            color = Color(0xFFF2EBE9),
            style = bodyMediumLeftStyle().copy(
                textAlign = TextAlign.Center,
                lineHeight = 20.sp
            ),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = card.subtitle,
            color = Color(0xFFA29C9A),
            style = captionSmallCenteredStyle(),
            maxLines = 1
        )
    }
}

@Composable
private fun UltradianChip(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .size(width = 122.dp, height = 58.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(Color.White.copy(alpha = 0.10f))
            .padding(horizontal = 10.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HomepageAssetImage(
            assetPath = "file:///android_asset/homepage/ultradian_icon.png",
            modifier = Modifier.size(22.dp)
        )

        Box(
            modifier = Modifier
                .width(76.dp)
                .height(40.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Ultradian",
                    color = Color(0xFFF2EBE9),
                    style = smallSubtitleLeftStyle()
                )
                Text(
                    "Rhythm",
                    color = Color(0xFFF2EBE9),
                    style = smallSubtitleLeftStyle()
                )
            }
        }
    }
}
