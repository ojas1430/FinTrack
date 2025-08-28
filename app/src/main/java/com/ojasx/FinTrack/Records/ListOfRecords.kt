package com.ojasx.FinTrack.Records

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ListOfRecords(
    viewModel: RecordsViewModel = viewModel()
) {
    val records by viewModel.recordlist.observeAsState(emptyList())

    Column {
        RecordsTopAppBar()
        if (records.isEmpty()) {
            NoRecordsYet()
        } else {
            ListOfRecords()
        }
    }

}