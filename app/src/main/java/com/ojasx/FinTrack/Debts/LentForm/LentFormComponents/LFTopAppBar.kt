package com.ojasx.FinTrack.Debts.LentForm.LentFormComponents

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.ojasx.FinTrack.StatusBarColor
import com.ojasx.FinTrack.ui.theme.walletgreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LentFormTopAppBarCode() {
    StatusBarColor()

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = walletgreen,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        },
        title = {
            Text("I Lent", fontWeight = FontWeight.Bold, color = Color.White)
        },
        actions = {
            IconButton(onClick = {  }) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    )
}
