package com.ojasx.wallet_clone.Screens.HomeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.tv.material3.Text
import com.ojasx.wallet_clone.Screens.Accounts.ListOfAccounts.ListOfAccountsMainScreen
import com.ojasx.wallet_clone.TopAppBar.topbarscreen

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
    }
}
