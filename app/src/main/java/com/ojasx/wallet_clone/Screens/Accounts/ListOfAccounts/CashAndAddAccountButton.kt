package com.ojasx.wallet_clone.Screens.Accounts.ListOfAccounts

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon

import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ojasx.wallet_clone.ui.theme.purpleBlue
import com.ojasx.wallet_clone.ui.theme.walletblue


@Preview
@Composable
fun CashAndAddAccountButton() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(onClick = {}, modifier = Modifier.weight(1f)
            .height(60.dp),

            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = walletblue,
                contentColor = Color.White
            )) {
            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start) {
                Text("Cash")
                Text("$0")
            }
        }

        OutlinedButton(
            onClick = {},
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.weight(1f).height(60.dp),
            border = BorderStroke(1.dp, color = purpleBlue)

        ) {
            Text("ADD ACCOUNT", color = purpleBlue, modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "",
                tint = purpleBlue,

                )
        }


    }
}
