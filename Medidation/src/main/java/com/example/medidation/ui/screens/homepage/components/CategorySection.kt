package com.example.medidation.ui.screens.homepage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.medidation.ui.bigSubtitleCenteredStyle
import com.example.medidation.ui.bodySmallCenteredStyle
import com.example.medidation.ui.screens.homepage.CategoryCardUi
import com.example.medidation.ui.screens.homepage.HomepageCategoryBackgroundStyle
import com.example.medidation.ui.screens.homepage.categoryCardHeight
import com.example.medidation.ui.screens.homepage.categoryCardWidth

@Composable
internal fun CategorySection(
    modifier: Modifier = Modifier,
    items: List<CategoryCardUi>
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        itemsIndexed(items) { index, item ->
            CategoryCard(item = item, index = index)
        }
    }
}

@Composable
private fun CategoryCard(item: CategoryCardUi, index: Int) {
    Box(
        modifier = Modifier
            .size(width = categoryCardWidth, height = categoryCardHeight)
            .clip(RoundedCornerShape(12.dp))
    ) {
        CategoryGlowLayer(index)
        CategoryForegroundLayer(item)
    }
}

@Composable
private fun BoxScope.CategoryGlowLayer(index: Int) {
    val assetPath = if (index % 2 == 0) {
        "file:///android_asset/homepage/category_vector_left.png"
    } else {
        "file:///android_asset/homepage/category_vector_right.png"
    }

    HomepageAssetImage(
        assetPath = assetPath,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds,
        alpha = 1f
    )
}

@Composable
private fun BoxScope.CategoryForegroundLayer(item: CategoryCardUi) {
    val contentOffsetY = when (item.backgroundStyle) {
        HomepageCategoryBackgroundStyle.Recent,
        HomepageCategoryBackgroundStyle.Created -> (-3).dp
        HomepageCategoryBackgroundStyle.Relax -> 12.dp
        else -> 24.dp
    }
    val iconOffsetY = when (item.backgroundStyle) {
        HomepageCategoryBackgroundStyle.Recent,
        HomepageCategoryBackgroundStyle.Created -> 14.dp
        else -> 0.dp
    }
    val iconTextGap = when (item.backgroundStyle) {
        HomepageCategoryBackgroundStyle.Relax -> (-4).dp
        else -> 10.dp
    }
    val titleHeight = when (item.backgroundStyle) {
        HomepageCategoryBackgroundStyle.Relax -> 22.dp
        else -> 58.dp
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(cardSecondLayerBrush(item.backgroundStyle))
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = contentOffsetY),
            verticalArrangement = Arrangement.spacedBy(iconTextGap, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HomepageAssetImage(
                assetPath = item.imageAsset,
                modifier = Modifier
                    .offset(y = iconOffsetY)
                    .size(width = item.imageWidth, height = item.imageHeight),
                contentScale = ContentScale.Fit
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = item.title,
                    modifier = Modifier.size(width = item.titleWidth, height = titleHeight),
                    style = bigSubtitleCenteredStyle().copy(color = Color(0xFFF2EBE9)),
                    textAlign = TextAlign.Center
                )

                item.subtitle?.let { subtitle ->
                    Text(
                        text = subtitle,
                        style = bodySmallCenteredStyle().copy(color = Color(0xFFF2EBE9)),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

private fun cardSecondLayerBrush(style: HomepageCategoryBackgroundStyle): Brush =
    when (style) {
        HomepageCategoryBackgroundStyle.Premade -> Brush.verticalGradient(
            colors = listOf(
                Color.White.copy(alpha = 0.08f),
                Color(0xFF999999).copy(alpha = 0.08f)
            )
        )

        HomepageCategoryBackgroundStyle.Recent,
        HomepageCategoryBackgroundStyle.Relax,
        HomepageCategoryBackgroundStyle.Created,
        HomepageCategoryBackgroundStyle.SoftIvory -> Brush.linearGradient(
            colors = listOf(
                Color.White.copy(alpha = 0.08f),
                Color.White.copy(alpha = 0.08f)
            )
        )
    }
