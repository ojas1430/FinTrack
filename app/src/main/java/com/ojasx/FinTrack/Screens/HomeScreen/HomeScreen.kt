package com.ojasx.FinTrack.Screens.HomeScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import androidx.navigation.NavController
import com.ojasx.FinTrack.SideBar.ModalSidebar
import com.ojasx.FinTrack.SideBar.UserProfile.ProfileViewModel
import com.ojasx.FinTrack.TopAppBar.AppBarCode
import com.ojasx.FinTrack.PagerUnderline
import com.ojasx.FinTrack.Records.RecordsViewModel
import com.ojasx.FinTrack.Screens.Accounts.AccountsMainScreen
import com.ojasx.FinTrack.Screens.BudgetAndGoals.BudgetAndGoalsMainScreen
import com.ojasx.FinTrack.TopAppBar.TopAppBarButtons
import com.ojasx.FinTrack.ui.theme.walletblue
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    profileViewModel: ProfileViewModel,
    viewModel: RecordsViewModel
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 2 })

    ModalSidebar(
        drawerState = drawerState,
        onNavigate = { route ->
            scope.launch {
                drawerState.close()
                navController.navigate(route)
            }
        },
        navController = navController,
        profileViewModel
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Persistent buttons below top app bar
                TopAppBarButtons()

                PagerUnderline(
                    pagerState = pagerState,
                    selectedColor = Color(0xFF3C4A5C) //Color.Black
                )

                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxSize()
                ) { page ->
                    when (page) {
                        0 -> AccountsMainScreen(navController,viewModel)
                        1 -> BudgetAndGoalsMainScreen()
                    }
                }
            }
        }

        ActionBottomSheet(
            showBottomSheet = showBottomSheet,
            onDismiss = { showBottomSheet = false },
            onTemplateClick = { /* handle template click */ },
            onNewRecordClick = { navController.navigate("CalculatorScreen") }
        )
    }
}