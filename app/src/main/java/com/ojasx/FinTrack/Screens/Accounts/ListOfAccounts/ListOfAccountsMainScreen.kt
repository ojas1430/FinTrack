package com.ojasx.FinTrack.Screens.Accounts.ListOfAccounts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ojasx.FinTrack.Records.RecordsViewModel

@Composable
fun ListOfAccountsMainScreen(
    navController: NavController,
    viewModel: RecordsViewModel
) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Spacer(Modifier.height(24.dp))
            Row {
                ListOfAccountsText()
                Spacer(Modifier.weight(1f))
                RoundedSettingButton()
                Spacer(Modifier.width(20.dp))
            }
            CashAndAddAccountButton(viewModel)
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                AccountDetailButton()
                Spacer(Modifier.weight(1f))
                RecordButton(navController)

            }
            Spacer(Modifier.height(8.dp))
        }
    }


