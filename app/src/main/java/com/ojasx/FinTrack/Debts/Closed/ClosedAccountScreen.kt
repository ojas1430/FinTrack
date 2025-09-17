package com.ojasx.FinTrack.Debts.Closed

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ojasx.FinTrack.Budgets.BudgetViewModel
import com.ojasx.FinTrack.Budgets.PeriodicBudgets.NewBudgetForm.NewBudgetComponents.NoBudgetYet

@Composable
fun ClosedAccountScreen(budgetViewModel: BudgetViewModel) {
    val budgets by budgetViewModel.budgets.observeAsState(emptyList())

    if (budgets.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
            ,
            contentAlignment = Alignment.Center
        ) { NoClosedDebtsYet() }
    } else {

    }

}