package com.ojasx.FinTrack.Screens.HomeScreen

import com.ojasx.FinTrack.SideBar.ModalSidebar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ojasx.FinTrack.Records.RecordsViewModel
import com.ojasx.FinTrack.Screens.Accounts.LazyListCards.LazyListOfCards
import com.ojasx.FinTrack.Screens.Accounts.ListOfAccounts.ListOfAccountsMainScreen
import com.ojasx.FinTrack.Screens.Accounts.PremiumClub.PremiumClubCard
import com.ojasx.FinTrack.Statistics.StatisticsMainScreen
import com.ojasx.FinTrack.StatusBarColor
import com.ojasx.FinTrack.TopAppBar.AppBarButtons
import com.ojasx.FinTrack.TopAppBar.AppBarCode
import com.ojasx.FinTrack.ui.theme.walletblue
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: RecordsViewModel
) {
    var showBottomSheet by remember { mutableStateOf(false) }

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    StatusBarColor()

    ModalSidebar(
        drawerState = drawerState,
        onNavigate = { route ->
            scope.launch {
                drawerState.close()
                navController.navigate(route)
            }
        },
        navController = navController
    ) {
        Scaffold(
            topBar = { AppBarCode(drawerState) },
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
                item {
                    StatisticsMainScreen(viewModel)
                }
            }
        }

        ActionBottomSheet(
            showBottomSheet = showBottomSheet,
            onDismiss = { showBottomSheet = false },
            onTemplateClick = {
                println("Template clicked")
            },
            onNewRecordClick = {
                navController.navigate("CalculatorScreen")
            }
        )
    }
}
