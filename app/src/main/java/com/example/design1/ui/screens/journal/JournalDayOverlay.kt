package com.example.design1.ui.screens.journal

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.design1.R
import com.example.design1.ui.bigSubtitleLeftStyle
import com.example.design1.ui.screens.journal.components.OverlayDateHeader
import com.example.design1.ui.screens.journal.components.OverlaySectionHeader
import com.example.design1.ui.screens.journal.components.SheetChevronButton
import com.example.design1.ui.screens.journal.cards.DreamCard
import com.example.design1.ui.screens.journal.cards.JournalEntryCard
import com.example.design1.ui.screens.journal.cards.MeditationCard
import com.example.design1.ui.screens.journal.cards.SessionCard
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource

@Composable
internal fun JournalDayOverlay(onClose: () -> Unit) {
    val overlayScroll = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xCC000000))
            .clickable { onClose() }
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.92f)
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(Color(0xFF221D1B))
                .clickable(enabled = false) {}
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .verticalScroll(overlayScroll)
                        .padding(top = 4.dp, bottom = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(4.dp)
                            .fillMaxWidth(0.10f)
                            .clip(RoundedCornerShape(40.dp))
                            .background(Color(0xFFF2EBE9))
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(modifier = Modifier.fillMaxWidth()) {
                        OverlayDateHeader()
                        SheetChevronButton(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(end = 16.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            OverlaySectionHeader("Journal Entries")
                            JournalEntryCard()
                        }
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            OverlaySectionHeader("Dreams")
                            DreamCard()
                        }
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            OverlaySectionHeader("Session")
                            SessionCard()
                        }
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            OverlaySectionHeader("Meditation")
                            MeditationCard()
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF292423))
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(100.dp))
                            .background(Color(0xFFF2EBE9))
                            .clickable { onClose() }
                            .height(46.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Close",
                            color = Color(0xFF373967),
                            style = bigSubtitleLeftStyle().copy(
                                fontSize = 17.sp,
                                lineHeight = 22.sp,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.home_indicator),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(21.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

