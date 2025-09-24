package com.ojasx.FinTrack.Debts.LentForm

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.material3.MaterialTheme
import com.ojasx.FinTrack.Debts.LentForm.LentFormComponents.LFAccount
import com.ojasx.FinTrack.Debts.LentForm.LentFormComponents.LFAmountField
import com.ojasx.FinTrack.Debts.LentForm.LentFormComponents.LFDate
import com.ojasx.FinTrack.Debts.LentForm.LentFormComponents.LFDescription
import com.ojasx.FinTrack.Debts.LentForm.LentFormComponents.LFDueDate
import com.ojasx.FinTrack.Debts.LentForm.LentFormComponents.LFName
import com.ojasx.FinTrack.Debts.LentForm.LentFormComponents.LentFormTopAppBarCode
import com.ojasx.FinTrack.StatusBarColor

@Composable
fun LFFormMainScreen(
    navController: NavController,
    lentViewModel: LentViewModel
){

    var colors = MaterialTheme.colorScheme
    // Set status bar color once
    StatusBarColor()

    Scaffold(
        topBar = { LentFormTopAppBarCode(navController,lentViewModel) },
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(colors.background)
                .padding(innerPadding)
        ) {
            item { LFName(lentViewModel) }
            item { LFDescription(lentViewModel) }
            item { LFAccount(lentViewModel) }
            item { LFAmountField(lentViewModel) }
            item { LFDate() }
            item { LFDueDate() }
        }
    }
}
