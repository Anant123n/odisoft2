package com.example.design1.ui.screens.podcast.settings

internal data class SettingsToggleItem(
    val id: String,
    val title: String,
    val subtitle: String,
    val defaultEnabled: Boolean = true
)

internal data class SettingsSliderItem(
    val id: String,
    val title: String,
    val subtitle: String,
    val labels: List<String>,
    val defaultPosition: Float = 0.5f
)

internal val podcastAccessItems = listOf(
    SettingsToggleItem("dreams", "Dreams", "Include dream analysis"),
    SettingsToggleItem("journal", "Journal", "Include journal entries"),
    SettingsToggleItem("care", "Care", "Include insights from Therapy Session"),
    SettingsToggleItem("meditate", "Meditate", "Include insights from meditation results")
)

internal val sliderSectionItems = listOf(
    SettingsSliderItem(
        id = "podcast_style",
        title = "Podcast Style",
        subtitle = "Select how you want the podcast sound",
        labels = listOf("Direct", "Neutral", "Gentle")
    ),
    SettingsSliderItem(
        id = "tone",
        title = "Tone",
        subtitle = "Choose how podcast members communicate",
        labels = listOf("Grounded", "Neutral", "Mystical")
    )
)

internal val backgroundMusicItem = SettingsToggleItem(
    id = "background_music",
    title = "Background Music",
    subtitle = "Include background ambience"
)
