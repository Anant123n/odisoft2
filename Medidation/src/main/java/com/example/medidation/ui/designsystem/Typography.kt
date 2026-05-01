package com.example.medidation.ui.designsystem

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.medidation.R

private val workSansFamily = FontFamily(
    Font(R.font.work_sans_medium, FontWeight.Medium),
    Font(R.font.work_sans_semibold, FontWeight.SemiBold)
)

private val ibmPlexSansFamily = FontFamily(
    Font(R.font.ibm_plex_sans_regular, FontWeight.Normal)
)

internal fun bodyMediumLeftStyle(): TextStyle = TextStyle(
    fontFamily = workSansFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 26.sp,
    letterSpacing = 0.16.sp,
    textAlign = TextAlign.Left
)

internal fun bodySmallCenteredStyle(): TextStyle = TextStyle(
    fontFamily = ibmPlexSansFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 21.sp,
    letterSpacing = 0.14.sp,
    textAlign = TextAlign.Center
)

internal fun bodySmallLeftStyle(): TextStyle = bodySmallCenteredStyle().copy(textAlign = TextAlign.Left)

internal fun bigSubtitleCenteredStyle(): TextStyle = TextStyle(
    fontFamily = workSansFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 17.sp,
    lineHeight = 22.sp,
    letterSpacing = 0.17.sp,
    textAlign = TextAlign.Center
)

internal fun bigSubtitleLeftStyle(): TextStyle = bigSubtitleCenteredStyle().copy(textAlign = TextAlign.Left)

internal fun smallSubtitleLeftStyle(): TextStyle = TextStyle(
    fontFamily = workSansFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 19.sp,
    letterSpacing = 0.14.sp,
    textAlign = TextAlign.Left
)

internal fun captionSmallCenteredStyle(): TextStyle = TextStyle(
    fontFamily = workSansFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.12.sp,
    textAlign = TextAlign.Center
)

internal fun captionSmallLeftStyle(): TextStyle = captionSmallCenteredStyle().copy(textAlign = TextAlign.Left)

internal fun captionXSmallCenteredStyle(): TextStyle = TextStyle(
    fontFamily = workSansFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 10.sp,
    lineHeight = 13.sp,
    letterSpacing = 0.1.sp,
    textAlign = TextAlign.Center
)
