package com.ojasx.FinTrack.Records

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun RecordsMainScreen(navController: NavController) {
    Scaffold(
        topBar = { RecordsTopAppBar() }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            ListOfRecords()
        }
    }
}