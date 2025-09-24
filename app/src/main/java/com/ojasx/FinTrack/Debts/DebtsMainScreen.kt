package com.ojasx.FinTrack.Debts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.ojasx.FinTrack.Budgets.BudgetViewModel
import com.ojasx.FinTrack.Budgets.PeriodicBudgets.NewBudgetForm.NewBudgetComponents.NoBudgetYet
import com.ojasx.FinTrack.Debts.DebtsTopAppBar.DebtsTopBarMainScreen
import com.ojasx.FinTrack.Budgets.BudgetFAB.DebtsPopOutButtonsWithFAB
import com.ojasx.FinTrack.Debts.Active.ActiveAccountScreen
import com.ojasx.FinTrack.Debts.Closed.ClosedAccountScreen
import com.ojasx.FinTrack.PagerUnderline
import com.ojasx.FinTrack.ui.theme.walletblue
import com.ojasx.FinTrack.ui.theme.walletgreen

@OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
fun DebtsMainScreen(
    navController: NavController,
    budgetViewModel: BudgetViewModel
) {
    var colors = MaterialTheme.colorScheme
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 2 })

    Scaffold(
        topBar = { DebtsTopBarMainScreen(navController) },
        floatingActionButton = { DebtsPopOutButtonsWithFAB(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            PagerUnderline(
                pagerState = pagerState,
                selectedColor = colors.primary
            )

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                when (page) {
                    0 -> ActiveAccountScreen(budgetViewModel)
                    1 -> ClosedAccountScreen(budgetViewModel)
                }
            }
        }
    }
}
