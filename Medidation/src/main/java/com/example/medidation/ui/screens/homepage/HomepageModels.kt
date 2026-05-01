package com.example.medidation.ui.screens.homepage

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal data class PromptCardUi(
    val title: String,
    val subtitle: String,
    val width: Dp,
    val height: Dp = 58.dp,
    val rotation: Float = 0f
)

internal data class CategoryCardUi(
    val title: String,
    val subtitle: String? = null,
    val imageAsset: String,
    val glowAsset: String = "file:///android_asset/homepage/category_glow.svg",
    val backgroundStyle: HomepageCategoryBackgroundStyle = HomepageCategoryBackgroundStyle.SoftIvory,
    val showGradient: Boolean = false,
    val iconFrameSize: Dp = 48.dp,
    val iconFramePadding: Dp = 8.dp,
    val glowAlignment: HomepageGlowAlignment = HomepageGlowAlignment.BottomLeft,
    val imageAlignment: HomepageImageAlignment = HomepageImageAlignment.TopCenter,
    val imageWidth: Dp = 40.dp,
    val imageHeight: Dp = 40.dp,
    val imageOffsetX: Dp = 0.dp,
    val imageOffsetY: Dp = 0.dp,
    val titleWidth: Dp = 107.dp
)

internal enum class HomepageGlowAlignment {
    BottomLeft,
    TopRight,
    BottomRight
}

internal enum class HomepageImageAlignment {
    TopCenter,
    TopEnd,
    Center
}

internal enum class HomepageCategoryBackgroundStyle {
    Premade,
    Recent,
    Relax,
    Created,
    SoftIvory
}

internal data class NavItemUi(
    val label: String,
    val iconAsset: String,
    val selected: Boolean = false
)

internal val promptCards = listOf(
    PromptCardUi(
        title = "Relax from yesterday’s nightmares...",
        subtitle = "Based on your dream",
        width = 314.dp
    ),
    PromptCardUi(
        title = "Deep dive into today’s adventure",
        subtitle = "Based on your journal entry",
        width = 292.dp,
        rotation = 3f
    ),
    PromptCardUi(
        title = "Understand your feelings",
        subtitle = "Based on your archetype",
        width = 230.dp
    ),
    PromptCardUi(
        title = "Communicate with your inner self",
        subtitle = "Based on your weekly activities",
        width = 300.dp,
        rotation = -3f
    ),
    PromptCardUi(
        title = "Get relaxed",
        subtitle = "Based on your archetype",
        width = 176.dp
    )
)

internal val categoryCards = listOf(
    CategoryCardUi(
        title = "Premade\nMeditations",
        imageAsset = "file:///android_asset/homepage/category_premade_new.svg",
        backgroundStyle = HomepageCategoryBackgroundStyle.Premade,
        showGradient = false,
        imageWidth = 33.6.dp,
        imageHeight = 35.07.dp,
        titleWidth = 109.dp
    ),
    CategoryCardUi(
        title = "Recent &\nFavorites",
        imageAsset = "file:///android_asset/homepage/category_recent.png",
        backgroundStyle = HomepageCategoryBackgroundStyle.Recent,
        showGradient = false,
        imageWidth = 60.dp,
        imageHeight = 60.dp,
        titleWidth = 109.dp
    ),
    CategoryCardUi(
        title = "Relax Now",
        subtitle = "3 Minute",
        imageAsset = "file:///android_asset/homepage/category_relax.png",
        backgroundStyle = HomepageCategoryBackgroundStyle.Relax,
        showGradient = false,
        imageWidth = 59.dp,
        imageHeight = 59.dp,
        titleWidth = 109.dp
    ),
    CategoryCardUi(
        title = "Created By\nYou",
        imageAsset = "file:///android_asset/homepage/category_created.png",
        backgroundStyle = HomepageCategoryBackgroundStyle.Created,
        showGradient = false,
        imageWidth = 60.dp,
        imageHeight = 60.dp,
        titleWidth = 109.dp
    )
)

internal val bottomNavItems = listOf(
    NavItemUi("home", "file:///android_asset/homepage/nav_home.svg"),
    NavItemUi("dreams", "file:///android_asset/homepage/nav_dreams.svg"),
    NavItemUi("journal", "file:///android_asset/homepage/nav_journal.svg"),
    NavItemUi("meditate", "file:///android_asset/homepage/nav_meditate.svg", selected = true),
    NavItemUi("more", "file:///android_asset/homepage/nav_more.svg")
)

internal val categoryCardWidth = 117.dp
internal val categoryCardHeight = 166.dp
