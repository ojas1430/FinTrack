package com.ojasx.FinTrack

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.ojasx.FinTrack.ui.theme.walletgreen
import kotlinx.coroutines.launch

@Composable
fun PagerUnderline(
    pagerState: androidx.compose.foundation.pager.PagerState,
    selectedColor: Color = Color.Green
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val indicatorWidth = screenWidth / pagerState.pageCount

    val indicatorOffset by animateDpAsState(
        targetValue = indicatorWidth * pagerState.currentPage,
        label = "pager_underline_offset"
    )

    Column {
        // Base line
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(Color.LightGray)
        ) {
            // Moving indicator
            Box(
                modifier = Modifier
                    .offset(x = indicatorOffset)
                    .width(indicatorWidth)
                    .height(8.dp)
                    .background(selectedColor)
            )
        }
    }
}

