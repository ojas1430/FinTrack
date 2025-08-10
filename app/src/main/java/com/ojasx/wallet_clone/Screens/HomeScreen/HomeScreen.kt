package com.ojasx.wallet_clone.Screens.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Text
import com.ojasx.wallet_clone.Screens.Accounts.LazyListCards.LazyListOfCards
import com.ojasx.wallet_clone.Screens.Accounts.ListOfAccounts.ListOfAccountsMainScreen
import com.ojasx.wallet_clone.Screens.Accounts.PremiumClub.PremiumClubCard
import com.ojasx.wallet_clone.TopAppBar.topbarscreen
import com.ojasx.wallet_clone.ui.theme.warmwhite

@Preview
@Composable
fun HomeScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            topbarscreen()
        }
        item {
            ListOfAccountsMainScreen()
        }

        item { 
            WarmWhiteBackground()
        }

    }
}

@Composable
fun WarmWhiteBackground() {
    Box(modifier = Modifier.fillMaxSize().background(color = warmwhite)
        .padding(14.dp)){
        Spacer(Modifier.height(12.dp))
        Column {
            LazyListOfCards()
            Spacer(Modifier.height(12.dp))
            PremiumClubCard()
        }
    }
}