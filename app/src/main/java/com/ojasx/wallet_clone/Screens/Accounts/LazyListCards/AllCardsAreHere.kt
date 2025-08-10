package com.ojasx.wallet_clone.Screens.Accounts.LazyListCards

import androidx.compose.animation.core.animateDecay
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ojasx.wallet_clone.R
import dev.chrisbanes.snapper.rememberLazyListSnapperLayoutInfo
import kotlinx.coroutines.flow.distinctUntilChanged
import androidx.compose.animation.core.exponentialDecay
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState

@Composable
fun Card1(modifier: Modifier) {
    Card(
        modifier = modifier
            .height(100.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Image
            Image(
                painter = painterResource(id = R.drawable.business),
                contentDescription = "",
                modifier = Modifier.size(50.dp)
            )
            Spacer(Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 4.dp)
            ) {
                Text(
                    "FinTrack for your business",
                    fontWeight = FontWeight.Medium
                )

                Spacer(Modifier.height(6.dp))

                Text(
                    "A smart app designed for entrepreneurs and small business.",
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun Card2(modifier: Modifier) {
    Card(
        modifier = modifier
            .height(100.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Image
            Image(
                painter = painterResource(id = R.drawable.storage),
                contentDescription = "",
                modifier = Modifier.size(50.dp)
            )
            Spacer(Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 4.dp)
            ) {
                Text(
                    "Keep Your Data Safe",
                    fontWeight = FontWeight.Medium
                )

                Spacer(Modifier.height(6.dp))

                Text(
                    "Your information is backed up securely and synced across all your devices, so you never lose track.",
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun Card3(modifier: Modifier) {
    Card(
        modifier = modifier
            .height(100.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Image
            Image(
                painter = painterResource(id = R.drawable.countdown),
                contentDescription = "",
                modifier = Modifier.size(50.dp)
            )
            Spacer(Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 4.dp)
            ) {
                Text(
                    "FinTrack Reminder",
                    fontWeight = FontWeight.Medium
                )

                Spacer(Modifier.height(6.dp))

                Text(
                    "Get alerts when you forget to record spending.",
                    color = Color.Gray
                )
            }
        }
    }
}

// ... existing code ...

@Composable
fun Card4(modifier: Modifier) {
    Card(
        modifier = modifier
            .height(100.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Image
            Image(
                painter = painterResource(id = R.drawable.bank),
                contentDescription = "",
                modifier = Modifier.size(50.dp)
            )
            Spacer(Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 4.dp)
            ) {
                Text(
                    "Add More Accounts",
                    fontWeight = FontWeight.Medium
                )

                Spacer(Modifier.height(6.dp))

                Text(
                    "Add accounts to match every part of your financial life.",
                    color = Color.Gray
                )
            }
        }
    }
}

// ... existing code ...

    @Composable
    fun Card5(modifier: Modifier) {
        Card(
            modifier = modifier
                .height(100.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // Image
                Image(
                    painter = painterResource(id = R.drawable.calendar),
                    contentDescription = "",
                    modifier = Modifier.size(50.dp)
                )
                Spacer(Modifier.width(12.dp))

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 4.dp)
                ) {
                    Text(
                        "Schedule Payments",
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(Modifier.height(6.dp))

                    Text(
                        "Add upcoming payments and forecast your finances",
                        color = Color.Gray
                    )
                }
            }
        }
    }

    @Composable
    fun LazyListOfCards() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            val liststate = rememberLazyListState()
            val itemscount = 5
            var currentindex by remember { mutableStateOf(0) }



            LaunchedEffect(liststate) {
                snapshotFlow { liststate.firstVisibleItemIndex }
                    .distinctUntilChanged()
                    .collect { index ->
                        currentindex = index
                    }
            }

            LazyRow(
                state = liststate,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
               contentPadding = PaddingValues(horizontal = 2.dp),
                flingBehavior = rememberSnapFlingBehavior(lazyListState = liststate)


            ) {
                item {
                    Card1(modifier = Modifier.width(LocalConfiguration.current.screenWidthDp.dp - 32.dp))
                }
                item {
                    Card2(modifier = Modifier.width(LocalConfiguration.current.screenWidthDp.dp - 32.dp))
                }
                item {
                    Card3(modifier = Modifier.width(LocalConfiguration.current.screenWidthDp.dp - 32.dp))
                }
                item {
                    Card4(modifier = Modifier.width(LocalConfiguration.current.screenWidthDp.dp - 32.dp))
                }
                item {
                    Card5(modifier = Modifier.width(LocalConfiguration.current.screenWidthDp.dp - 32.dp))
                }
            }

            // Add space between cards and dots
            Spacer(Modifier.height(8.dp))

            // Dots indicator
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(itemscount) { index ->
                    Box(
                        modifier = Modifier
                            .size(if (index == currentindex) 10.dp else 8.dp)
                            .background(
                                color = if (index == currentindex) Color.Black else Color.Gray,
                                shape = CircleShape
                            )
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                }
            }
        }
    }