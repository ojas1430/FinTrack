package com.ojasx.wallet_clone.Screens.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Text
import com.ojasx.wallet_clone.Screens.Accounts.LazyListCards.LazyListOfCards
import com.ojasx.wallet_clone.Screens.Accounts.ListOfAccounts.ListOfAccountsMainScreen
import com.ojasx.wallet_clone.Screens.Accounts.PremiumClub.PremiumClubCard
import com.ojasx.wallet_clone.TopAppBar.topbarscreen
import com.ojasx.wallet_clone.ui.theme.warmwhite
import java.nio.file.WatchEvent

import androidx.compose.material3.Scaffold
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import com.ojasx.wallet_clone.StatusBarColor
import com.ojasx.wallet_clone.TopAppBar.AppBarCode
import com.ojasx.wallet_clone.ui.theme.walletblue
import com.ojasx.wallet_clone.ui.theme.walletgreen

@Preview

@Composable
fun HomeScreen() {

    Scaffold(
        topBar = { AppBarCode() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Your FAB action here */ },
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
//            item {
//                topbarscreen()
//            }
            item {
                ListOfAccountsMainScreen()
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
}

@Preview
@Composable
fun MainScreen() {
    HomeScreen()
}