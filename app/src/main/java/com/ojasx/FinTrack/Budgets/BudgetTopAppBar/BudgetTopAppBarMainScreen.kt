package com.ojasx.FinTrack.Budgets.BudgetTopAppBar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ojasx.FinTrack.Budgets.BudgetTopAppBarCode

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BudgetTopBarMainScreen() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    Column() {
        BudgetTopAppBarCode(drawerState)
        BudgetTopAppBarButtons()
    }
}
