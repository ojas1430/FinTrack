package com.ojasx.FinTrack.Screens.HomeScreen

import com.ojasx.FinTrack.Screens.Accounts.AccountsMainScreen
import com.ojasx.FinTrack.Screens.BudgetAndGoals.BudgetAndGoalsMainScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.ojasx.FinTrack.Budgets.BudgetViewModel
import com.ojasx.FinTrack.Debts.Active.ActiveAccountScreen
import com.ojasx.FinTrack.Debts.Closed.ClosedAccountScreen
import com.ojasx.FinTrack.PagerUnderline
import com.ojasx.FinTrack.Records.RecordsViewModel
import com.ojasx.FinTrack.ui.theme.walletgreen

@OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
fun MainSwipeableScreen(
    navController: NavController,
    budgetViewModel: BudgetViewModel,
    recordsViewModel: RecordsViewModel,
    isBlurEnabled: Boolean,
    onBlurChanged: (Boolean) -> Unit,
) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 2 })

    Scaffold(
        topBar = {
            PagerUnderline(
                pagerState = pagerState,
                selectedColor = Color.Gray
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
                0 -> AccountsMainScreen(navController,recordsViewModel,isBlurEnabled,onBlurChanged)
                1 -> BudgetAndGoalsMainScreen()
            }
        }
    }
}