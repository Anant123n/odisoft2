package com.example.medidation.ui.screens.custommeditation

import androidx.compose.ui.graphics.Color

internal val ScreenBackground = Color(0xFF171312)
internal val PrimaryText = Color(0xFFF2EBE9)
internal val SecondaryText = Color(0xFFA29C9A)
internal val CardBackground = Color(0xFF221D1B)
internal val ChipBackground = Color(0xFF423C3A)
internal val Accent = Color(0xFFFE6847)
internal val AccentText = Color(0xFF642D20)
internal val SelectedWhaleBackground = Color(0xFF293D3B)
internal val SelectedWhaleBorder = Color(0xFFA7CFCB)

internal data class VoiceOption(
    val name: String,
    val imageAsset: String
)

internal data class DurationOption(
    val label: String,
    val minutes: Int
)

internal val customMeditationTitles = listOf(
    "Morning Meditation",
    "Afternoon Meditation",
    "Evening Meditation",
    "Night Meditation"
)

internal enum class SoundCardStyle {
    FitBottom,
    Fill,
    FullImage
}

internal data class SoundOption(
    val title: String,
    val assetPath: String? = null,
    val style: SoundCardStyle,
    val imageWidth: Int? = null,
    val imageHeight: Int? = null,
    val overlayAssetPath: String? = null
)

internal val customMeditationVoiceOptions = listOf(
    VoiceOption("Mira", "file:///android_asset/custom_meditation/voice_mira-5c7623.png"),
    VoiceOption("Amara", "file:///android_asset/custom_meditation/voice_amara-3e518f.png"),
    VoiceOption("Elara", "file:///android_asset/custom_meditation/voice_elara-79d159.png"),
    VoiceOption("Elias", "file:///android_asset/custom_meditation/voice_elias-2b978c.png"),
    VoiceOption("Landon", "file:///android_asset/custom_meditation/voice_landon-16cef2.png"),
    VoiceOption("Rowan", "file:///android_asset/custom_meditation/voice_rowan-4f0b88.png")
)

internal val customMeditationSoundOptions = listOf(
    SoundOption(
        title = "Music",
        assetPath = "file:///android_asset/custom_meditation/sound_music-325757.png",
        style = SoundCardStyle.FitBottom,
        imageWidth = 108,
        imageHeight = 88
    ),
    SoundOption(
        title = "Nature",
        assetPath = "file:///android_asset/custom_meditation/sound_nature_bg1.png",
        style = SoundCardStyle.Fill,
        overlayAssetPath = "file:///android_asset/custom_meditation/sound_nature_bg2.png"
    ),
    SoundOption(
        title = "Silence",
        assetPath = "file:///android_asset/custom_meditation/sound_silence.png",
        style = SoundCardStyle.Fill
    ),
    SoundOption(
        title = "White Noise",
        assetPath = "file:///android_asset/custom_meditation/white_noise_card.png",
        style = SoundCardStyle.FullImage
    ),
    SoundOption(
        title = "Ocean",
        assetPath = "file:///android_asset/custom_meditation/sound_ocean.png",
        style = SoundCardStyle.Fill
    ),
    SoundOption(
        title = "Fire",
        assetPath = "file:///android_asset/custom_meditation/sound_fire-1c79c1.png",
        style = SoundCardStyle.FitBottom,
        imageWidth = 152,
        imageHeight = 96
    ),
    SoundOption(
        title = "whale",
        assetPath = "file:///android_asset/custom_meditation/sound_whale-105f91.png",
        style = SoundCardStyle.FitBottom,
        imageWidth = 164,
        imageHeight = 80
    ),
    SoundOption(
        title = "Rain",
        assetPath = "file:///android_asset/custom_meditation/sound_rain.png",
        style = SoundCardStyle.Fill
    ),
    SoundOption(
        title = "Bowl",
        assetPath = "file:///android_asset/custom_meditation/sound_bowl.png",
        style = SoundCardStyle.FitBottom,
        imageWidth = 110,
        imageHeight = 82
    ),
    SoundOption(
        title = "Chimes",
        assetPath = "file:///android_asset/custom_meditation/sound_chimes-5ae107.png",
        style = SoundCardStyle.FitBottom,
        imageWidth = 70,
        imageHeight = 98
    )
)

internal val customMeditationDurationOptions = listOf(
    DurationOption("5m", 5),
    DurationOption("10m", 10),
    DurationOption("15m", 15),
    DurationOption("20m", 20),
    DurationOption("25m", 25),
    DurationOption("30m", 30),
    DurationOption("Extended Session", 45)
)
