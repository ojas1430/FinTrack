package com.ojasx.FinTrack.Debts.DebtsTopAppBar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DebtsTopBarMainScreen(navController: NavController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    Column() {
        DebtTopAppBarCode(drawerState)
        DebtsTopAppBarButtons(navController)
    }
}
