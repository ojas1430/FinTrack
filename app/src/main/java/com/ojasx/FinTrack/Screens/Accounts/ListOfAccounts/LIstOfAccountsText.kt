package com.ojasx.FinTrack.Screens.Accounts.ListOfAccounts

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListOfAccountsText() {
    val colors = MaterialTheme.colorScheme

    Spacer(Modifier.width(15.dp))
    Text(
        "List of accounts",
        color = colors.onBackground,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,

        )
}
