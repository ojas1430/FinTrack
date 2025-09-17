package com.ojasx.FinTrack.Debts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
fun SwipeableScreens() {
    val pagerState = rememberPagerState(initialPage = 0)
    val scope = rememberCoroutineScope()

    HorizontalPager(
        count = 2,
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        when (page) {
            0 -> {
                ActiveAccountScreen()
            }
            1 -> {
                ClosedAccountScreen()
            }
        }
    }
}
