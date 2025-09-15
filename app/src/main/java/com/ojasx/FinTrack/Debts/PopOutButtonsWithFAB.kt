package com.ojasx.FinTrack.Budgets.BudgetFAB

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.tv.material3.Icon
import com.ojasx.FinTrack.ui.theme.walletblue

@Composable
fun DebtsPopOutButtonsWithFAB(navController: NavController) {
    var isExpanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Dim background when expanded
        if (isExpanded) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
                    .clickable { isExpanded = false }
            )
        }

        // Pop-out buttons (only visible when expanded)
        if (isExpanded) {
            Column(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 16.dp, bottom = 80.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = {
                        isExpanded = false
                        navController.navigate("NewBudgetFormMainScreen")
                    }
                ) {
                    androidx.compose.material.Text("New Budget")
                }

                Button(
                    onClick = {
                        isExpanded = false
                        // 👇 Navigate to some other screen if you want
                        navController.navigate("SomeOtherScreen")
                    }
                ) {
                    androidx.compose.material.Text("Other Action")
                }
            }
        }

        // Main FAB
        FloatingActionButton(
            onClick = { isExpanded = !isExpanded },
            shape = CircleShape,
            backgroundColor = walletblue,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
                .size(60.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(34.dp)
            )
        }
    }
}
