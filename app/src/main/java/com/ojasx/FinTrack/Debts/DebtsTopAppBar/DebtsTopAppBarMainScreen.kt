package com.ojasx.FinTrack.Debts.DebtsTopAppBar

import com.ojasx.FinTrack.Budgets.BudgetTopAppBar.BudgetTopAppBarButtons
import com.ojasx.FinTrack.Budgets.BudgetTopAppBar.BudgetTopAppBarCode
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DebtsTopBarMainScreen() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    Column() {
        DebtTopAppBarCode(drawerState)
        DebtsTopAppBarButtons()
    }
}
