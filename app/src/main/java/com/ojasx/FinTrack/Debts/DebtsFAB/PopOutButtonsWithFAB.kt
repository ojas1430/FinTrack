package com.ojasx.FinTrack.Budgets.BudgetFAB

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavController
import androidx.tv.material3.Icon
import com.ojasx.FinTrack.ui.theme.walletblue

@Composable
fun DebtsPopOutButtonsWithFAB(navController: NavController) {
    var isExpanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {

        // Full-screen overlay and pop-out buttons
        if (isExpanded) {
            Popup(
                onDismissRequest = { isExpanded = false },
                // Make it full-screen, ignoring parent constraints
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.4f))
                        .clickable { isExpanded = false }
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 24.dp, bottom = 90.dp),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.End
                ) {
                    ILentButton {
                        isExpanded = false
                        navController.navigate("LFFormMainScreen")
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    IBorrowedButton {
                        isExpanded = false
                        navController.navigate("IBorrowedScreen")
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = { isExpanded = !isExpanded },
            shape = CircleShape,
            backgroundColor = walletblue,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
                .size(60.dp)
        ) {
            androidx.compose.material.Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}
@Composable
fun ILentButton(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "I Lent", color = Color.Black)
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(Color.Red.copy(alpha = 0.15f))
        ) {
            Icon(
                imageVector = Icons.Default.ArrowUpward,
                contentDescription = "Lent",
                tint = Color.Red
            )
        }
    }
}

@Composable
fun IBorrowedButton(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "I Borrowed", color = Color.Black)
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(Color.Green.copy(alpha = 0.15f))
        ) {
            Icon(
                imageVector = Icons.Default.ArrowDownward,
                contentDescription = "Borrowed",
                tint = Color.Green
            )
        }
    }
}
