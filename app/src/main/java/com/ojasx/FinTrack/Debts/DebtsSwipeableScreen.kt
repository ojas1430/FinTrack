package com.ojasx.FinTrack.Debts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ojasx.FinTrack.Budgets.BudgetViewModel
import com.ojasx.FinTrack.Debts.Active.ActiveAccountScreen
import com.ojasx.FinTrack.Debts.Closed.ClosedAccountScreen
import com.ojasx.FinTrack.PagerUnderline
import com.ojasx.FinTrack.ui.theme.walletgreen

@OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
fun SwipeableScreens(budgetViewModel: BudgetViewModel) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 2 })

    Scaffold(
        topBar = {
            PagerUnderline(
                pagerState = pagerState, // androidx.compose.foundation.pager.PagerState
                selectedColor = walletgreen
            )
        }
    ) { paddingValues ->
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) { page ->
            when (page) {
                0 -> ActiveAccountScreen(budgetViewModel)
                1 -> ClosedAccountScreen(budgetViewModel)
            }
        }
    }
}