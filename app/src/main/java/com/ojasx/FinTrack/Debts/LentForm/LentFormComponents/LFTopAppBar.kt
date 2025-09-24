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
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.ojasx.FinTrack.Debts.CreateConfirmationDialog
import com.ojasx.FinTrack.Debts.LentForm.LentViewModel
import com.ojasx.FinTrack.ExitConfirmationDialog
import com.ojasx.FinTrack.StatusBarColor
import com.ojasx.FinTrack.ui.theme.walletgreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LentFormTopAppBarCode(
    navController: NavController,
    lentViewModel: LentViewModel
) {
    StatusBarColor()

    var colors = MaterialTheme.colorScheme
    var showExitDialog by remember { mutableStateOf(false) }
    var showCreateDialog by remember { mutableStateOf(false) }

    if (showExitDialog) {
        ExitConfirmationDialog(
            onDismiss = { showExitDialog = false },
            onConfirm = {
                showExitDialog = false
                navController.popBackStack()
            }
        )
    }
    if (showCreateDialog) {
        CreateConfirmationDialog(
            onDismiss = { showCreateDialog = false },
            onConfirm = {
                showCreateDialog = false
                val saved = lentViewModel.saveBudget()
                if (saved) {
                    navController.popBackStack()
                }
            }
        )
    }

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colors.secondary,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        navigationIcon = {
            IconButton(onClick = {
                showExitDialog = true
            }) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Close",
                    tint = Color.White
                )
            }
        },
        title = {
            Text("I Lent", fontWeight = FontWeight.Bold, color = Color.White)
        },
        actions = {
            IconButton(onClick = {
                // ✅ Validate when tick icon is clicked
                val isValid = lentViewModel.validateAll()
                if (isValid) {
                    showCreateDialog = true
                }
                // If not valid, `nameError` LiveData will update → UI will show error
            }) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Save",
                    tint = Color.White
                )
            }
        }
    )
}

