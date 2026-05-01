package com.example.medidation.ui.screens.custommeditation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.medidation.ui.bodyMediumLeftStyle
import com.example.medidation.ui.screens.custommeditation.PrimaryText
import com.example.medidation.ui.screens.custommeditation.SecondaryText

@Composable
internal fun MentionSection(
    mentionText: String,
    onMentionTextChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Anything you'd like mentioned during this\nmeditation?",
            color = PrimaryText,
            style = bodyMediumLeftStyle().copy(textAlign = TextAlign.Center),
            modifier = Modifier.fillMaxWidth()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 48.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White.copy(alpha = 0.09f))
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            BasicTextField(
                value = mentionText,
                onValueChange = onMentionTextChange,
                textStyle = bodyMediumLeftStyle().merge(TextStyle(color = PrimaryText)),
                modifier = Modifier.fillMaxWidth(),
                decorationBox = { innerTextField ->
                    if (mentionText.isEmpty()) {
                        Text(
                            text = "Enter here",
                            color = SecondaryText,
                            style = bodyMediumLeftStyle()
                        )
                    }
                    innerTextField()
                }
            )
        }
    }
}
