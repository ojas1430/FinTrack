package com.ojasx.FinTrack.Debts.DebtsTopAppBar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ojasx.FinTrack.ui.theme.walletgreen

@Composable
fun DebtsTopAppBarButtons(navController: NavController) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = {

            },
            shape = RectangleShape,
            modifier = Modifier
                .weight(1f)
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = walletgreen
            )
        ) {
            Text(text = "ACTIVE")
        }
        Button(
            onClick = {

            },
            shape = RectangleShape,
            modifier = Modifier
                .weight(1f)
                .height(40.dp)
            , colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = walletgreen
            )
        ) {
            Text(text = "CLOSED")
        }
    }
}