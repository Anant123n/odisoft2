package com.example.medidation.ui.screens.homepage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medidation.ui.bodyMediumLeftStyle

@Composable
internal fun MeditationInputBar(
    modifier: Modifier = Modifier,
    placeholder: String = "Design your own meditation",
    onSend: (String) -> Unit = {}
) {
    var value by rememberSaveable { mutableStateOf("") }
    val shape = RoundedCornerShape(40.dp)
    val interactionSource = remember { MutableInteractionSource() }
    val sendInteractionSource = remember { MutableInteractionSource() }
    val hasText = value.isNotBlank()

    fun submit() {
        if (hasText) {
            onSend(value.trim())
        }
    }

    Surface(
        modifier = modifier,
        shape = shape,
        color = Color.White.copy(alpha = 0.10f),
        tonalElevation = 0.dp,
        shadowElevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .height(64.dp)
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val inputTextStyle = bodyMediumLeftStyle().merge(
                TextStyle(
                    color = Color(0xFFA29C9A),
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    letterSpacing = TextUnit.Unspecified
                )
            )

            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                BasicTextField(
                    value = value,
                    onValueChange = { value = it },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    cursorBrush = SolidColor(Color(0xFFF4EEEB)),
                    textStyle = inputTextStyle.copy(color = Color(0xFFF4EEEB)),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
                    keyboardActions = KeyboardActions(
                        onSend = { submit() }
                    ),
                    interactionSource = interactionSource,
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            if (value.isEmpty()) {
                                Text(
                                    text = placeholder,
                                    color = Color(0xFFA29C9A),
                                    style = inputTextStyle,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                            innerTextField()
                        }
                    }
                )
            }

            Box(
                modifier = Modifier
                    .size(20.dp),
                contentAlignment = Alignment.Center
            ) {
                HomepageAssetImage(
                    assetPath = "file:///android_asset/homepage/input_mic_figma.svg",
                    modifier = Modifier.size(width = 14.dp, height = 17.dp),
                    alpha = 1f
                )
            }

            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(
                        Color(0xFFFE6847).copy(alpha = if (hasText) 1f else 0.4f)
                    )
                    .clickable(
                        enabled = hasText,
                        indication = null,
                        interactionSource = sendInteractionSource
                    ) { submit() },
                contentAlignment = Alignment.Center
            ) {
                HomepageAssetImage(
                    assetPath = "file:///android_asset/homepage/input_send_figma.svg",
                    modifier = Modifier.size(20.dp),
                    alpha = if (hasText) 1f else 0.72f
                )
            }
        }
    }
}
