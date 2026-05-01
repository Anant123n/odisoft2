package com.example.medidation.ui.screens.homepage.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.medidation.R
import com.example.medidation.ui.captionXSmallCenteredStyle
import com.example.medidation.ui.screens.homepage.NavItemUi

@Composable
internal fun BottomNavigationSection(
    modifier: Modifier = Modifier,
    items: List<NavItemUi>
) {
    var selectedLabel by rememberSaveable {
        mutableStateOf(items.firstOrNull { it.selected }?.label ?: items.firstOrNull()?.label.orEmpty())
    }

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Color(0xFF221D1B))
            .navigationBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items.forEach { item ->
                NavItem(
                    item = item.copy(selected = item.label == selectedLabel),
                    modifier = Modifier.weight(1f),
                    onClick = { selectedLabel = item.label }
                )
            }
        }
    }
}

@Composable
private fun NavItem(
    item: NavItemUi,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(40.dp))
            .clickable(onClick = onClick)
            .padding(vertical = 2.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(40.dp))
                .background(
                    if (item.selected) Color(0xFF7D3C2F).copy(alpha = 0.88f) else Color.Transparent
                )
                .padding(
                    horizontal = if (item.selected) 8.dp else 4.dp,
                    vertical = if (item.selected) 8.dp else 5.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            if (item.selected) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .offset(x = (-15).dp, y = (-8).dp)
                        .size(31.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.04f))
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = 22.dp, y = 0.dp)
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.04f))
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Box(
                    modifier = Modifier.size(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    if (item.label == "meditate") {
                        Image(
                            painter = painterResource(id = R.drawable.meditate_selected_icon),
                            contentDescription = null,
                            modifier = Modifier.size(18.dp),
                            colorFilter = if (item.selected) {
                                null
                            } else {
                                ColorFilter.tint(Color(0xFFB6B0AF))
                            }
                        )
                    } else {
                        HomepageAssetImage(
                            assetPath = item.iconAsset,
                            modifier = Modifier.size(18.dp),
                            colorFilter = ColorFilter.tint(Color(0xFFB6B0AF))
                        )
                    }
                }

                Text(
                    item.label,
                    color = if (item.selected) Color(0xFFF2EBE9) else Color(0xFFB6B0AF),
                    style = captionXSmallCenteredStyle(),
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )
            }
        }
    }
}
