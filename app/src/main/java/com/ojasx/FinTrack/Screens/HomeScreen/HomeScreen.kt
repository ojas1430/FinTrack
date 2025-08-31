package com.ojasx.FinTrack.Screens.HomeScreen

import androidx.compose.foundation.background
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
import com.ojasx.FinTrack.Screens.Accounts.LazyListCards.LazyListOfCards
import com.ojasx.FinTrack.Screens.Accounts.ListOfAccounts.ListOfAccountsMainScreen
import com.ojasx.FinTrack.Screens.Accounts.PremiumClub.PremiumClubCard
import com.ojasx.FinTrack.ui.theme.warmwhite

import androidx.compose.material3.Scaffold
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.ojasx.FinTrack.Records.RecordsViewModel
import com.ojasx.FinTrack.TopAppBar.AppBarButtons
import com.ojasx.FinTrack.TopAppBar.AppBarCode
import com.ojasx.FinTrack.ui.theme.walletblue


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: RecordsViewModel
) {
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { AppBarCode() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showBottomSheet = true },
                containerColor = walletblue
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.White
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                AppBarButtons()
            }
            item {
                ListOfAccountsMainScreen(navController, viewModel)
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = warmwhite)
                        .padding(14.dp)
                ) {
                    Column {
                        LazyListOfCards()
                        Spacer(Modifier.height(12.dp))
                        PremiumClubCard()
                        Spacer(Modifier.height(12.dp))
                    }
                }
            }
        }
    }
    ActionBottomSheet(
        showBottomSheet = showBottomSheet,
        onDismiss = { showBottomSheet = false },
        onTemplateClick = {
            // Handle template creation
            println("Template clicked")
            // Add your navigation here
        },
        onNewRecordClick = {
            navController.navigate("CalculatorScreen")

        }
    )
}


