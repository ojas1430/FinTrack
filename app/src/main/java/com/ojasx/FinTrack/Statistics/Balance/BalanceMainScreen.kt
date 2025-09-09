package com.ojasx.FinTrack.Statistics.Balance

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BalanceMainScreen(history: List<BalancePoint>,) {
    Column(modifier = Modifier.fillMaxSize()){
        BalanceGraph(history)
        BalanceByAccounts(history)
        BalanceByCurrency(history)
    }
}