package com.ojasx.FinTrack.Budgets

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Icon
import com.ojasx.FinTrack.ui.theme.walletblue

@Composable
fun BudgetsFloatingButton() {
    FloatingActionButton(
        onClick = { },
        shape = CircleShape,
        backgroundColor = walletblue,
        modifier = Modifier.size(60.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier.size(34.dp)
        )
    }
}