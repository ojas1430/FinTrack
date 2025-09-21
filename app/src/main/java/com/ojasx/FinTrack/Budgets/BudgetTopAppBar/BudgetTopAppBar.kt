package com.ojasx.FinTrack.Budgets

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.ojasx.FinTrack.StatusBarColor
import com.ojasx.FinTrack.ui.theme.walletgreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BudgetTopAppBarCode(drawerState: DrawerState) {
    val colors = MaterialTheme.colorScheme
    val scope = rememberCoroutineScope()

    StatusBarColor()

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colors.secondary,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        navigationIcon = {
            IconButton(
                onClick = { scope.launch { drawerState.open() } }
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }
        },
        title = {
            Text(
                "Budgets",
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        },
    )
}