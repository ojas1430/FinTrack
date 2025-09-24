package com.ojasx.FinTrack.Screens.Accounts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.ojasx.FinTrack.Records.RecordsViewModel
import com.ojasx.FinTrack.Screens.Accounts.LazyListCards.LazyListOfCards
import com.ojasx.FinTrack.Screens.Accounts.ListOfAccounts.ListOfAccountsMainScreen
import com.ojasx.FinTrack.Screens.Accounts.PremiumClub.PremiumClubCard
import com.ojasx.FinTrack.Screens.HomeScreen.ActionBottomSheet
import com.ojasx.FinTrack.Statistics.StatisticsMainScreen

@Composable
fun AccountsMainScreen(
    navController: NavController,
    viewModel: RecordsViewModel,
    isBlurEnabled: Boolean,
    onBlurChanged: (Boolean) -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding()
        ) {
            item {
                ListOfAccountsMainScreen(
                    navController,
                    viewModel,
                    isBlurEnabled = isBlurEnabled,
                    onBlurChanged = onBlurChanged)
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp)
                ) {
                    Column {
                        ->
                        LazyListOfCards()
                        Spacer(Modifier.height(12.dp))
                        PremiumClubCard()
                        Spacer(Modifier.height(12.dp))
                    }
                }
            }
            item {
                StatisticsMainScreen(viewModel)
            }
        }
    }
}