package com.ojasx.FinTrack.Budgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ojasx.FinTrack.Budgets.BudgetFAB.BudgetsFloatingActionButton
import com.ojasx.FinTrack.Budgets.BudgetTopAppBar.BudgetTopBarMainScreen
import com.ojasx.FinTrack.Budgets.budgetDynamicCards.BudgetCard
import com.ojasx.FinTrack.Records.RecordsViewModel
import com.ojasx.FinTrack.Budgets.PeriodicBudgets.NewBudgetForm.NewBudgetComponents.NoBudgetYet

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

        if (budgets.isEmpty()) {
            // Show NoBudgetYet screen
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                NoBudgetYet() // your custom composable
            }
        } else {
            // Show budget list
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(budgets) { budget ->
                    BudgetCard(
                        budgetViewModel = budgetViewModel,
                        viewModel = recordsViewModel
                    )
                }
            }
        }
    }
}
