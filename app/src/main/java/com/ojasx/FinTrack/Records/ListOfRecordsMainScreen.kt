package com.ojasx.FinTrack.Records

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun ListOfRecords(
    navController: NavController,
    viewModel: RecordsViewModel = viewModel()
) {
    val colors = MaterialTheme.colorScheme
    val records by viewModel.recordlist.observeAsState(emptyList())

    Column {
        RecordsTopAppBar(viewModel, navController)

        if (records.isEmpty()) {
            // Show full-screen empty state
            NoRecordsYet()
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()
                .background(colors.background)) {
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
}