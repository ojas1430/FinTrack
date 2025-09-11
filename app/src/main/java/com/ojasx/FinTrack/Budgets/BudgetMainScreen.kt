package com.ojasx.FinTrack.Budgets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.Scaffold
import com.ojasx.FinTrack.Budgets.BudgetFAB.BudgetsFloatingActionButton
import com.ojasx.FinTrack.Budgets.BudgetTopAppBar.BudgetTopAppBarButtons
import com.ojasx.FinTrack.Budgets.BudgetTopAppBar.BudgetTopBarMainScreen
import com.ojasx.FinTrack.Budgets.PeriodicBudgets.PeriodicBudgetsMainScreen

@Preview
@Composable
fun BudgetMainScreen() {
    Scaffold(
        //passing top app bar
        topBar = { BudgetTopBarMainScreen() },

        // passing Budgets FAB
        floatingActionButton = {
            BudgetsFloatingActionButton()
        }

    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ){
            item {
                PeriodicBudgetsMainScreen()
            }

        }

    }
}