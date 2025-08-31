package com.ojasx.FinTrack.Records

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ListOfRecords(
    viewModel: RecordsViewModel = viewModel()
) {
    val records by viewModel.recordlist.observeAsState(emptyList())

    Column {
        RecordsTopAppBar(viewModel)
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                if (records.isEmpty()) {
                NoRecordsYet()
            } else {
                records.forEach { record ->
                    RecordCard(record)
                }
            }
            }

        }
    }
}