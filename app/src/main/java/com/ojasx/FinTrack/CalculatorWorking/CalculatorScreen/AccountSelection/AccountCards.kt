package com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.AccountSelection

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ojasx.FinTrack.R

@Composable
fun AccountCards() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.moneybag),
                contentDescription = "Money Bag",
                modifier = Modifier.size(48.dp)
            )
            Spacer(Modifier.width(20.dp))
            Column {
                Text("Cash")
                Text("Cash", color = Color.Gray)
            }
        }
    }
}
