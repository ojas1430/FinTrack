package com.ojasx.FinTrack.Statistics

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ojasx.FinTrack.Records.RecordsViewModel
import com.ojasx.FinTrack.Statistics.Balance.BalanceByAccounts
import com.ojasx.FinTrack.Statistics.Balance.BalanceByCurrency
import com.ojasx.FinTrack.Statistics.Balance.BalanceGraph


@Composable
fun StatisticsMainScreen(viewModel: RecordsViewModel = viewModel()) {
    val history by viewModel.balanceHistory.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        BalanceGraph(history)
        BalanceByAccounts(history)
        BalanceByCurrency(history)
    }
}
