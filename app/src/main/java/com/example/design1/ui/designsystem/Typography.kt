package com.example.design1.ui.designsystem

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.design1.R

private val robotoFamily = FontFamily(
    Font(R.font.roboto_medium, FontWeight.Medium)
)

private val workSansFamily = FontFamily(
    Font(R.font.work_sans_medium, FontWeight.Medium),
    Font(R.font.work_sans_semibold, FontWeight.SemiBold)
)

private val plusJakartaSansFamily = FontFamily(
    Font(R.font.plus_jakarta_sans_medium, FontWeight.Medium),
    Font(R.font.plus_jakarta_sans_bold, FontWeight.Bold)
)

private val ibmPlexSansFamily = FontFamily(
    Font(R.font.ibm_plex_sans_regular, FontWeight.Normal)
)

internal fun robotoTimeStyle(): TextStyle = TextStyle(
    fontFamily = robotoFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 20.sp
)

internal fun h3Style(): TextStyle = TextStyle(
    fontFamily = plusJakartaSansFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 28.sp,
    lineHeight = 34.sp
)

internal fun h4Style(): TextStyle = TextStyle(
    fontFamily = plusJakartaSansFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    lineHeight = 29.sp
)

internal fun h4CenteredStyle(): TextStyle = h4Style().copy(textAlign = TextAlign.Center)

internal fun bodySmallCenteredStyle(): TextStyle = TextStyle(
    fontFamily = ibmPlexSansFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 21.sp,
    textAlign = TextAlign.Center
)

internal fun bodySmallLeftStyle(): TextStyle = bodySmallCenteredStyle().copy(textAlign = TextAlign.Left)

internal fun bigSubtitleCenteredStyle(): TextStyle = TextStyle(
    fontFamily = workSansFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 17.sp,
    lineHeight = 22.sp,
    textAlign = TextAlign.Center
)

internal fun bigSubtitleLeftStyle(): TextStyle = bigSubtitleCenteredStyle().copy(textAlign = TextAlign.Left)

internal fun smallSubtitleLeftStyle(): TextStyle = TextStyle(
    fontFamily = workSansFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 19.sp,
    textAlign = TextAlign.Left
)

internal fun smallTitleStyle(): TextStyle = TextStyle(
    fontFamily = plusJakartaSansFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 20.sp,
    lineHeight = 26.sp
)

internal fun captionSmallLeftStyle(): TextStyle = TextStyle(
    fontFamily = workSansFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    lineHeight = 16.sp
)

internal fun captionXSmallLeftStyle(): TextStyle = TextStyle(
    fontFamily = workSansFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 10.sp,
    lineHeight = 13.sp
)

internal fun bodyMediumLeftStyle(): TextStyle = TextStyle(
    fontFamily = workSansFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 26.sp,
    textAlign = TextAlign.Left
)

