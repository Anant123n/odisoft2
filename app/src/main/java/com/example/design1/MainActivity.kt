package com.example.design1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.design1.ui.theme.Design1Theme
import androidx.compose.foundation.verticalScroll

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Design1Theme(darkTheme = true, dynamicColor = false) {
                PodcastScreen()
            }
        }
    }
}

@Composable
private fun PodcastScreen() {
    val mainScroll = rememberScrollState()
    val weekScroll = rememberScrollState()
    var showOverlay by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF171312))
                .verticalScroll(mainScroll)
        ) {
            HeaderSection()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HeroSection()
            }

            Spacer(modifier = Modifier.height(16.dp))
            MainCardSection(weekScroll = weekScroll, onDateClick = { showOverlay = true })
            Spacer(modifier = Modifier.height(20.dp))
            ArcDeepDiveSection()
            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HistorySection()
                Spacer(modifier = Modifier.height(12.dp))
            }

            Image(
                painter = painterResource(id = R.drawable.home_indicator),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(21.dp),
                contentScale = ContentScale.FillBounds
            )
        }

        if (showOverlay) {
            JournalDayOverlay(onClose = { showOverlay = false })
        }
    }
}

@Composable
private fun HeaderSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .padding(horizontal = 24.dp, vertical = 12.dp)
        ) {
            Text(
                text = "9:30",
                color = Color(0xFFE6E1DB),
                style = robotoTimeStyle(),
                modifier = Modifier.align(Alignment.CenterStart)
            )
            Image(
                painter = painterResource(id = R.drawable.status_icons),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(width = 46.dp, height = 17.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.camera_cutout),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .size(24.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painter = painterResource(id = R.drawable.back_button), contentDescription = null, modifier = Modifier.size(36.dp))
            Text(
                text = "Podcast",
                color = Color(0xFFF2EBE9),
                style = bigSubtitleCenteredStyle()
            )
            Image(painter = painterResource(id = R.drawable.menu_button), contentDescription = null, modifier = Modifier.size(36.dp))
        }
    }
}

@Composable
private fun HeroSection() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.hero_image_735834),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(244.dp)
                .clip(RoundedCornerShape(bottomStart = 80.dp, bottomEnd = 80.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Podcasts Shaped by You",
            color = Color(0xFFF2EBE9),
            textAlign = TextAlign.Center,
            style = h3Style().copy(textAlign = TextAlign.Center)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Our host Milo (mind) and Soma (body) will be organizing podcasts for you to reflect and grow.",
            color = Color(0xFFF2EBE9),
            textAlign = TextAlign.Center,
            style = bodySmallCenteredStyle(),
            modifier = Modifier.width(310.dp)
        )
    }
}

@Composable
private fun MainCardSection(
    weekScroll: androidx.compose.foundation.ScrollState,
    onDateClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF292423), RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Orange Card
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(listOf(Color(0xFFFE6847), Color(0xFF642D20))),
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            // Avatars with precise CSS styling and increased inner padding
            Row(
                modifier = Modifier.height(36.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy((-5.51).dp) // margin: 0px -5.50562px
            ) {
                // Frame 1000002534
                Image(
                    painter = painterResource(id = R.drawable.avatar_left_463f98),
                    contentDescription = null,
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFF574C47), CircleShape)
                        .border(1.57.dp, Color(0x80FFFFFF), CircleShape)
                        .padding(4.dp) // Inner padding to show background circle
                        .clip(CircleShape)
                )
                // Frame 1000002533
                Image(
                    painter = painterResource(id = R.drawable.avatar_right_49fcaf),
                    contentDescription = null,
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFFFFD89C), CircleShape)
                        .border(1.57.dp, Color(0x80FFFFFF), CircleShape)
                        .padding(4.dp) // Inner padding to show background circle
                        .clip(CircleShape)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Between the Lines",
                color = Color.White,
                style = h4Style()
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Your weekly activity turned into a personalized podcast to analyze process effectively",
                color = Color.White.copy(alpha = 0.9f),
                style = bodySmallLeftStyle(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CountdownItem("6", "Days")
                Text(":", color = Color.White, style = smallTitleStyle())
                CountdownItem("23", "Hours")
                Text(":", color = Color.White, style = smallTitleStyle())
                CountdownItem("32", "Minutes")
                Text(":", color = Color.White, style = smallTitleStyle())
                CountdownItem("40", "Seconds")
            }
            Spacer(modifier = Modifier.height(24.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .clip(RoundedCornerShape(100.dp))
                        .background(Color(0x66F2EBE9))
                        .padding(vertical = 14.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Start Listening",
                        color = Color(0xFF171312),
                        style = bigSubtitleLeftStyle().copy(fontWeight = FontWeight.SemiBold)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "💫 Keep engaging - The more you journal, dream, and reflect, the richer your weekly podcast becomes",
                color = Color(0xFFFFCDC2),
                textAlign = TextAlign.Center,
                style = bodySmallCenteredStyle()
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        // Calendar Row - Edge to Edge Background with Spaced Content
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF221D1B))
                .horizontalScroll(weekScroll)
                .padding(vertical = 16.dp, horizontal = 16.dp), // Added horizontal spacing
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val days = listOf(
                WeekDayUi("Mo", "15", isCompleted = true),
                WeekDayUi("Tue", "16", isCompleted = true),
                WeekDayUi("We", "17", isCompleted = true, showIndicatorDots = true),
                WeekDayUi("Fri", "19", isSelected = true, showIndicatorDots = true),
                WeekDayUi("Thu", "18", isDisabled = true),
                WeekDayUi("Sat", "20", isDisabled = true),
                WeekDayUi("Sun", "21", isDisabled = true)
            )
            days.forEach { day ->
                WeekDayCell(day = day, onClick = onDateClick)
            }
        }
    }
}

@Composable
private fun CountdownItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, color = Color.White, style = smallTitleStyle())
        Text(text = label, color = Color.White.copy(alpha = 0.6f), style = captionXSmallLeftStyle())
    }
}

@Composable
private fun HistorySection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Pod History",
                color = Color(0xFFF2EBE9),
                style = h4CenteredStyle()
            )
            Text(
                text = "Explore your podcast history from recent weeks",
                color = Color(0xFFF2EBE9),
                style = bodySmallCenteredStyle()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        HistoryCard(
            date = "January 20-26",
            title = "Exploring your personal values and beliefs",
            duration = "3h:00m",
            bgRes = R.drawable.history_card_1_bg,
            rightActionRes = R.drawable.right_button_1,
            playActionRes = R.drawable.play_button_1,
            progressRatio = 0.64f
        )
        Spacer(modifier = Modifier.height(8.dp))
        HistoryCard(
            date = "January 13-19",
            title = "The impact of your environment on behavior",
            duration = "1h:45m",
            bgRes = R.drawable.history_card_2_bg,
            rightActionRes = R.drawable.right_button_2,
            playActionRes = R.drawable.play_button_2,
            progressRatio = 0.50f
        )
        Spacer(modifier = Modifier.height(8.dp))
        HistoryCard(
            date = "January 5-12",
            title = "What makes you the way you are",
            duration = "2h:30m",
            bgRes = R.drawable.history_card_3_bg,
            rightActionRes = R.drawable.right_button_3,
            playActionRes = R.drawable.play_button_3,
            progressRatio = 0.78f
        )
    }
}

@Composable
private fun ArcDeepDiveSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    0f to Color.White.copy(alpha = 0.1f),
                    1f to Color(0xFF371E18).copy(alpha = 0.1f)
                ),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Container for overlapping cards
        Box(
            modifier = Modifier.padding(bottom = 43.dp), // Space for overlapping card
            contentAlignment = Alignment.BottomCenter
        ) {
            // Arc Deep Dive Card
            Box(
                modifier = Modifier
                    .size(width = 361.dp, height = 203.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        brush = Brush.verticalGradient(listOf(Color(0xFF574C47), Color(0xFF292423))),
                        alpha = 0.5f // Decreased from 0.8 to make it more dull/transparent
                    )
            ) {
                // Avatars positioned absolutely within the card
                Image(
                    painter = painterResource(id = R.drawable.avatar_right_49fcaf),
                    contentDescription = null,
                    modifier = Modifier
                        .size(106.dp)
                        .align(Alignment.BottomStart)
                        .offset(x = (-17).dp, y = 4.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = painterResource(id = R.drawable.avatar_left_463f98),
                    contentDescription = null,
                    modifier = Modifier
                        .size(118.dp)
                        .align(Alignment.BottomEnd)
                        .offset(x = 32.dp, y = 10.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                // Content in the middle of the card
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Arc Deep Dive",
                        color = Color(0xFFF2EBE9),
                        style = h4Style().copy(fontSize = 24.sp, textAlign = TextAlign.Center),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "Listen to the podcast about the full analysis\nof your personality\n3 Hours",
                        color = Color(0xFFF2EBE9),
                        style = bodySmallCenteredStyle(),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(330.dp)
                    )
                }

                // Start Listening Button
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 32.dp) // Moved up slightly to accommodate the overlapping card
                        .size(width = 166.dp, height = 54.dp)
                        .clip(RoundedCornerShape(100.dp))
                        .background(Color(0xFFF2EBE9).copy(alpha = 0.4f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Start Listening",
                        color = Color(0xFF171312),
                        style = bigSubtitleLeftStyle().copy(textAlign = TextAlign.Center)
                    )
                }
            }

            // Locked Podcast Section - Overlapping at the bottom
            Box(
                modifier = Modifier
                    .offset(y = 43.dp) // Overlap by roughly half its height
                    .size(width = 347.dp, height = 86.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF423C3A)) // Kept solid to be "less dull"
                    .border(0.5.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = "The Podcast is Locked",
                            color = Color(0xFFF2EBE9),
                            style = bigSubtitleLeftStyle()
                        )
                        Text(
                            text = "Unlock it by taking personality test",
                            color = Color(0xFFF2EBE9),
                            style = bodySmallLeftStyle()
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.lock_arrow_button),
                        contentDescription = null,
                        modifier = Modifier.size(36.dp)
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(43.dp)) // Compensation for the overlap offset
    }
}

@Composable
private fun HistoryCard(
    date: String,
    title: String,
    duration: String,
    bgRes: Int,
    rightActionRes: Int,
    playActionRes: Int,
    progressRatio: Float
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF423C3A))
    ) {
        Box(modifier = Modifier.fillMaxWidth().height(190.dp)) {
            Image(
                painter = painterResource(id = bgRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f))
                        )
                    )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(date, color = Color(0xFFA29C9A), style = captionSmallLeftStyle())
                Spacer(modifier = Modifier.height(4.dp))
                Text(title, color = Color(0xFFF2EBE9), style = bigSubtitleLeftStyle())
                Spacer(modifier = Modifier.height(4.dp))
                Text(duration, color = Color(0xFFB6B0AF), style = bodySmallLeftStyle())
            }
            Spacer(modifier = Modifier.width(12.dp))
            Image(painter = painterResource(id = rightActionRes), contentDescription = null, modifier = Modifier.size(36.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Image(painter = painterResource(id = playActionRes), contentDescription = null, modifier = Modifier.size(36.dp))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 6.dp, end = 6.dp, bottom = 6.dp)
                .height(4.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(Color(0x1AFFFFFF))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(progressRatio)
                    .height(4.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFFE6847))
            )
        }
    }
}

@Composable
private fun JournalDayOverlay(onClose: () -> Unit) {
    val overlayScroll = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xCC000000))
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.92f)
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(Color(0xFF221D1B))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
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
                            .size(width = 40.dp, height = 4.dp)
                            .clip(RoundedCornerShape(40.dp))
                            .background(Color(0xFFF2EBE9))
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(modifier = Modifier.fillMaxWidth()) {
                        SectionTitleRowWithMood()
                        CollapseChevronButton(
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

@Composable
private fun SectionTitleRowWithMood() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MoodIcon()
        Spacer(modifier = Modifier.width(8.dp))
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text("Tuesday", color = Color(0xCCF2EBE9), style = bigSubtitleLeftStyle())
            Text("3 November", color = Color(0xCCB6B0AF), style = smallSubtitleLeftStyle())
        }
    }
}

@Composable
private fun CollapseChevronButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(Color(0x1AFFFFFF)),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(18.dp)) {
            val color = Color(0xFFF2EBE9)
            val y = size.height * 0.42f
            val left = Offset(size.width * 0.22f, y)
            val mid = Offset(size.width * 0.50f, size.height * 0.68f)
            val right = Offset(size.width * 0.78f, y)
            drawLine(color = color, start = left, end = mid, strokeWidth = 2.2f, cap = StrokeCap.Round)
            drawLine(color = color, start = mid, end = right, strokeWidth = 2.2f, cap = StrokeCap.Round)
        }
    }
}

@Composable
private fun MoodIcon() {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(Color(0xFF2F244C))
            .padding(3.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .background(Color(0xFFEFA063)),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val eyeY = size.height * 0.38f
                val leftEyeX = size.width * 0.38f
                val rightEyeX = size.width * 0.62f
                val mouthY = size.height * 0.66f

                drawLine(
                    color = Color(0xB3000000),
                    start = Offset(leftEyeX - 3f, eyeY - 2f),
                    end = Offset(leftEyeX + 3f, eyeY + 2f),
                    strokeWidth = 2.2f,
                    cap = StrokeCap.Round
                )
                drawLine(
                    color = Color(0xB3000000),
                    start = Offset(leftEyeX + 3f, eyeY - 2f),
                    end = Offset(leftEyeX - 3f, eyeY + 2f),
                    strokeWidth = 2.2f,
                    cap = StrokeCap.Round
                )
                drawLine(
                    color = Color(0xB3000000),
                    start = Offset(rightEyeX - 3f, eyeY - 2f),
                    end = Offset(rightEyeX + 3f, eyeY + 2f),
                    strokeWidth = 2.2f,
                    cap = StrokeCap.Round
                )
                drawLine(
                    color = Color(0xB3000000),
                    start = Offset(rightEyeX + 3f, eyeY - 2f),
                    end = Offset(rightEyeX - 3f, eyeY + 2f),
                    strokeWidth = 2.2f,
                    cap = StrokeCap.Round
                )
                drawLine(
                    color = Color(0xB3000000),
                    start = Offset(size.width * 0.35f, mouthY),
                    end = Offset(size.width * 0.65f, mouthY),
                    strokeWidth = 2.4f,
                    cap = StrokeCap.Round
                )
            }
        }
    }
}

@Composable
private fun OverlaySectionHeader(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, color = Color(0xCCF2EBE9), style = bigSubtitleLeftStyle())
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(100.dp))
                .background(Color(0x1AFFFFFF))
                .padding(horizontal = 12.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Add", color = Color(0xFFF2EBE9), style = smallSubtitleLeftStyle())
        }
    }
}

@Composable
private fun JournalEntryCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF292423))
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text("Clouds began to gather,\nmirroring my thoughts.", color = Color(0xFFF2EBE9), style = bigSubtitleLeftStyle())
                Text("I wondered if the shift in weather wo...", color = Color(0xCCF2EBE9), style = bodySmallLeftStyle())
            }
            EntryGalleryIcon()
        }
    }
}

@Composable
private fun EntryGalleryIcon() {
    Box(modifier = Modifier.size(width = 82.79.dp, height = 63.79.dp)) {
        // Back card (Frame 1000002153): left 28.99%, top 0%, size 48x48, rotate 15deg
        Image(
            painter = painterResource(id = R.drawable.journal_entry_gallery_right),
            contentDescription = null,
            modifier = Modifier
                .offset(x = 24.dp, y = 0.dp)
                .size(48.dp)
                .rotate(15f)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
        // Front card (Frame 1000002154): left 0%, top 7.84%, size 48x48, rotate -15deg
        Image(
            painter = painterResource(id = R.drawable.journal_entry_gallery_left),
            contentDescription = null,
            modifier = Modifier
                .offset(y = 5.dp, x = 0.dp)
                .size(48.dp)
                .rotate(-15f)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun DreamCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF292423))
            .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0x1AFFFFFF))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text("In Progress", color = Color(0xFFF2EBE9), style = captionSmallLeftStyle())
            }
            Text("Lion Stalking Hoopoe at Home", color = Color(0xFFF2EBE9), style = bigSubtitleLeftStyle())
            Text("I saw a lion chasing my beopoe which was...", color = Color(0xCCB6B0AF), style = bodyMediumLeftStyle())
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.new_icon_moon_4),
                    contentDescription = null,
                    modifier = Modifier.size(14.dp),
                    contentScale = ContentScale.Crop
                )
                Text("Full Moon", color = Color(0xCCB6B0AF), style = captionSmallLeftStyle())
            }
        }
    }
}

@Composable
private fun SessionCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF292423))
            .padding(8.dp),
        verticalAlignment = Alignment.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.session_avatar_custom),
            contentDescription = null,
            modifier = Modifier.size(width = 40.dp, height = 56.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 4.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text("Dr. Sarah", color = Color(0xFFF2EBE9), style = bigSubtitleLeftStyle())
            Text("Your insights on dietary habits...", color = Color(0xCCB6B0AF), style = bodyMediumLeftStyle())
        }
        Text(
            "13:00",
            color = Color(0xFFA29C9A),
            style = smallSubtitleLeftStyle(),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
private fun MeditationCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF292423))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.meditation_illustration),
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text("Awaken to Presence", color = Color(0xFFF2EBE9), style = bigSubtitleLeftStyle())
            Text("Guided Visualization", color = Color(0xCCB6B0AF), style = bodyMediumLeftStyle())
        }
    }
}

@Composable
private fun WeekDayCell(day: WeekDayUi, onClick: () -> Unit) {
    val textColor = if (day.isDisabled) Color(0xFFB6B0AF).copy(alpha = 0.4f) else Color.White
    val subTextColor = if (day.isDisabled) Color(0xFFB6B0AF).copy(alpha = 0.4f) else Color.White
    
    Box(
        modifier = Modifier
            .clickable { onClick() }
            .clip(RoundedCornerShape(12.dp))
            .then(
                if (day.isSelected) Modifier.border(1.dp, Color(0xFF423C3A), RoundedCornerShape(16.dp)).background(Color(0xFF171312))
                else Modifier
            )
            .padding(vertical = 12.dp, horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = day.day, color = textColor, style = captionSmallLeftStyle().copy(fontWeight = FontWeight.Bold, textAlign = TextAlign.Center))
            Text(text = day.date, color = textColor, style = bodySmallLeftStyle().copy(fontWeight = FontWeight.Bold, fontSize = 16.sp, textAlign = TextAlign.Center))
            Text(text = "Nov", color = subTextColor, style = captionXSmallLeftStyle().copy(textAlign = TextAlign.Center))
            Spacer(modifier = Modifier.height(8.dp))
            if (day.isCompleted) {
                Image(
                    painter = painterResource(id = R.drawable.check_icon),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color(0xFFAECFA7)) // Light green check
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .clip(CircleShape)
                        .background(if (day.isSelected) Color(0xFF423C3A) else Color(0x1AFFFFFF))
                )
            }
        }
    }
}

private data class WeekDayUi(
    val day: String,
    val date: String,
    val isCompleted: Boolean = false,
    val checkRes: Int? = null,
    val showIndicatorDots: Boolean = false,
    val isSelected: Boolean = false,
    val isDisabled: Boolean = false,
    val hasBottomPill: Boolean = false
)

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

private fun robotoTimeStyle(): TextStyle = TextStyle(
    fontFamily = robotoFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 20.sp
)

private fun h3Style(): TextStyle = TextStyle(
    fontFamily = plusJakartaSansFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 28.sp,
    lineHeight = 34.sp
)

private fun h4Style(): TextStyle = TextStyle(
    fontFamily = plusJakartaSansFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    lineHeight = 29.sp
)

private fun h4CenteredStyle(): TextStyle = h4Style().copy(textAlign = TextAlign.Center)

private fun bodySmallCenteredStyle(): TextStyle = TextStyle(
    fontFamily = ibmPlexSansFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 21.sp,
    textAlign = TextAlign.Center
)

private fun bodySmallLeftStyle(): TextStyle = bodySmallCenteredStyle().copy(textAlign = TextAlign.Left)

private fun bigSubtitleCenteredStyle(): TextStyle = TextStyle(
    fontFamily = workSansFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 17.sp,
    lineHeight = 22.sp,
    textAlign = TextAlign.Center
)

private fun bigSubtitleLeftStyle(): TextStyle = bigSubtitleCenteredStyle().copy(textAlign = TextAlign.Left)

private fun smallSubtitleLeftStyle(): TextStyle = TextStyle(
    fontFamily = workSansFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 19.sp,
    textAlign = TextAlign.Left
)

private fun smallTitleStyle(): TextStyle = TextStyle(
    fontFamily = plusJakartaSansFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 20.sp,
    lineHeight = 26.sp
)

private fun captionSmallLeftStyle(): TextStyle = TextStyle(
    fontFamily = workSansFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    lineHeight = 16.sp
)

private fun captionXSmallLeftStyle(): TextStyle = TextStyle(
    fontFamily = workSansFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 10.sp,
    lineHeight = 13.sp
)

private fun bodyMediumLeftStyle(): TextStyle = TextStyle(
    fontFamily = workSansFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 26.sp,
    textAlign = TextAlign.Left
)

@Preview(showBackground = true)
@Composable
fun PodcastScreenPreview() {
    Design1Theme(darkTheme = true, dynamicColor = false) {
        PodcastScreen()
    }
}