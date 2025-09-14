package com.ojasx.FinTrack.Budgets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ojasx.FinTrack.Budgets.BudgetFAB.BudgetsFloatingActionButton
import com.ojasx.FinTrack.Budgets.BudgetTopAppBar.BudgetTopBarMainScreen
import com.ojasx.FinTrack.Budgets.PeriodicBudgets.PeriodicBudgetsMainScreen
import com.ojasx.FinTrack.Budgets.budgetDynamicCards.BudgetCard
import com.ojasx.FinTrack.Records.RecordsViewModel

@Composable
fun BudgetMainScreen(
    navController: NavController,
    budgetViewModel: BudgetViewModel,
    recordsViewModel: RecordsViewModel
) {
    // track of budgets dynamically
    val budgets by budgetViewModel.budgets.observeAsState(emptyList())

    Scaffold(
        topBar = { BudgetTopBarMainScreen() },
        floatingActionButton = {
            BudgetsFloatingActionButton(navController)
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                PeriodicBudgetsMainScreen()
            }

            //  Show all budgets dynamically
            items(budgets) { budget ->
                BudgetCard(
                    budgetViewModel = budgetViewModel,
                    viewModel = recordsViewModel
                )
            }
        }
    }
}