package com.ojasx.wallet_clone.Records

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun ListOfRecords(viewModel: RecordsViewModel = viewModel()) {
    val records by viewModel.recordlist.observeAsState(emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        if (records.isEmpty()) {
            Text("No records yet")
        } else {
            records.forEach { record ->
                RecordCard(record = record)
            }
        }
    }
}