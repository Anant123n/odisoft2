package com.example.medidation.ui.screens.custommeditation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medidation.ui.bigSubtitleCenteredStyle
import com.example.medidation.ui.bodyMediumLeftStyle
import com.example.medidation.ui.captionSmallCenteredStyle
import com.example.medidation.ui.screens.custommeditation.Accent
import com.example.medidation.ui.screens.custommeditation.AccentText
import com.example.medidation.ui.screens.custommeditation.PrimaryText
import com.example.medidation.ui.screens.custommeditation.SecondaryText
import com.example.medidation.ui.screens.homepage.components.HomepageAssetImage

@Composable
internal fun CustomMeditationHeader(
    meditationTitle: String,
    isEditingTitle: Boolean,
    editingMeditationTitle: String,
    onEditingMeditationTitleChange: (String) -> Unit,
    onEditTitle: () -> Unit,
    onSaveTitle: () -> Unit,
    onClose: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 6.dp, bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.size(44.dp))

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = "Custom",
                color = SecondaryText,
                style = captionSmallCenteredStyle().copy(
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    lineHeight = 16.sp
                )
            )

            Row(
                modifier = Modifier.wrapContentWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                if (isEditingTitle) {
                    TextField(
                        value = editingMeditationTitle,
                        onValueChange = onEditingMeditationTitleChange,
                        singleLine = true,
                        textStyle = bodyMediumLeftStyle().copy(color = PrimaryText),
                        shape = RoundedCornerShape(20.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White.copy(alpha = 0.10f),
                            unfocusedContainerColor = Color.White.copy(alpha = 0.10f),
                            disabledContainerColor = Color.White.copy(alpha = 0.10f),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            focusedTextColor = PrimaryText,
                            unfocusedTextColor = PrimaryText,
                            cursorColor = Accent
                        ),
                        modifier = Modifier.weight(1f)
                    )
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(Accent)
                            .clickable(onClick = onSaveTitle)
                            .padding(horizontal = 14.dp, vertical = 10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Save",
                            color = AccentText,
                            style = captionSmallCenteredStyle().copy(
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }
                } else {
                    Text(
                        text = meditationTitle,
                        color = PrimaryText,
                        style = bigSubtitleCenteredStyle(),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    HomepageAssetImage(
                        assetPath = "file:///android_asset/custom_meditation/header_edit.svg",
                        modifier = Modifier
                            .size(20.dp)
                            .clickable(onClick = onEditTitle)
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .size(36.dp)
                .clickable(onClick = onClose),
            contentAlignment = Alignment.Center
        ) {
            HomepageAssetImage(
                assetPath = "file:///android_asset/custom_meditation/header_close.svg",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
