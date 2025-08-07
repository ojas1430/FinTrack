package com.ojasx.wallet_clone.Screens.Accounts.ListOfAccounts

import android.R
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun AccountDetailButton(modifier: Modifier = Modifier) {
    TextButton(onClick = {}) {
        Box(
            modifier = Modifier
                .border(
                    width = 0.8.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(20)
                )
                .padding(horizontal = 10.dp, vertical = 5.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "ACCOUNT DETAIL",
                color = Color.Black,
                fontSize = 14.sp
            )
        }
    }
}
