package com.ojasx.FinTrack.TopAppBar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun topbarscreen() {
    Column(modifier = Modifier.fillMaxSize()) {

        AppBarCode()
        AppBarButtons()


    }
}