package com.ojasx.FinTrack.Debts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ojasx.FinTrack.Budgets.BudgetViewModel
import com.ojasx.FinTrack.Budgets.PeriodicBudgets.NewBudgetForm.NewBudgetComponents.NoBudgetYet
import com.ojasx.FinTrack.Debts.DebtsTopAppBar.DebtsTopBarMainScreen
import com.ojasx.FinTrack.Budgets.BudgetFAB.DebtsPopOutButtonsWithFAB

@OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
fun DebtsMainScreen(
    navController: NavController,
    budgetViewModel: BudgetViewModel
) {
    val budgets by budgetViewModel.budgets.observeAsState(emptyList())
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 2 })

    Scaffold(
        topBar = { DebtsTopBarMainScreen(navController) },
        floatingActionButton = { DebtsPopOutButtonsWithFAB(navController) }
    ) { paddingValues ->
        if (budgets.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) { NoBudgetYet() }
        } else {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) { page ->
                when (page) {
                    0 -> ActiveAccountScreen()
                    1 -> ClosedAccountScreen()
                }
            }
        }
    }
}