package com.ojasx.FinTrack.TopAppBar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ojasx.FinTrack.ui.theme.walletgreen

@Composable
fun TopAppBarButtons() {
    val colors = MaterialTheme.colorScheme

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
                containerColor = colors.secondary
            )
        ) {
            Text(text = "ACCOUNTS")
        }
        Button(
            onClick = {

            },
            shape = RectangleShape,
            modifier = Modifier
                .weight(1f)
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = colors.secondary
            )
        ) {
            Text(text = "BUDGET & GOALS")
        }
    }
}