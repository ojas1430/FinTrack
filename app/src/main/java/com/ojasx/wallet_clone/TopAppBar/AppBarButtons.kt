package com.ojasx.wallet_clone.TopAppBar

import android.widget.Button
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.ojasx.wallet_clone.ui.theme.walletgreen

@Composable
fun AppBarButtons(modifier: Modifier = Modifier) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { /* Handle ACCOUNTS click */ },
            shape = RectangleShape,
            modifier = Modifier
                .weight(1f)
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = walletgreen
            )
        ) {
            Text(text = "ACCOUNTS")
        }
        Button(
            onClick = { /* Handle BUDGETS & GOALS click */ },
            shape = RectangleShape,
            modifier = Modifier
                .weight(1f)
                .height(40.dp)
            , colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = walletgreen
            )
        ) {
            Text(text = "BUDGETS & GOALS")
        }
    }
}