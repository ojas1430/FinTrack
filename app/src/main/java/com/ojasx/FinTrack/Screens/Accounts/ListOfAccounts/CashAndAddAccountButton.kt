package com.ojasx.FinTrack.Screens.Accounts.ListOfAccounts

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
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ojasx.FinTrack.Records.RecordsViewModel
import com.ojasx.FinTrack.ui.theme.purpleBlue
import com.ojasx.FinTrack.ui.theme.walletblue



@Composable
fun CashAndAddAccountButton(viewModel: RecordsViewModel) {
    // summation of all card values
    val records by viewModel.recordlist.observeAsState(emptyList())
    val total = records.sumOf { it.amount.toIntOrNull() ?: 0 }
    val colors = MaterialTheme.colorScheme


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
                Text("₹${if (total >= 0) "+$total" else total}")
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
