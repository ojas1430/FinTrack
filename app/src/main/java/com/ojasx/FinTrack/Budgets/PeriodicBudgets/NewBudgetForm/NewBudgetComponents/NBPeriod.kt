package com.ojasx.FinTrack.Budgets.PeriodicBudgets.NewBudgetForm.NewBudgetComponents

import androidx.compose.material3.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ojasx.FinTrack.Budgets.BudgetViewModel
import com.ojasx.FinTrack.ThinLine
import com.ojasx.FinTrack.ui.theme.walletblue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NBPeriod(
    budgetViewModel: BudgetViewModel
) {
    val options = listOf("Week", "Month", "Year", "One time")
    var expanded by remember { mutableStateOf(false) }
    var isFocused by remember { mutableStateOf(false) }
    val colors = MaterialTheme.colorScheme
    val selectedOption by budgetViewModel.period.observeAsState(options[0])

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
    ) {
        androidx.compose.material.Text(
            text = "Period",
            color = Color.Gray,
            fontWeight = FontWeight.Medium
        )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                value = selectedOption,
                onValueChange = {},
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 20.sp,
                    color = colors.onBackground
                ),
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = walletblue,
                    unfocusedLabelColor = Color.Gray,
                    focusedContainerColor = colors.background,
                    unfocusedContainerColor = colors.background
                ),
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            budgetViewModel.updatePeriod(option) // ✅ Update ViewModel
                            expanded = false
                        }
                    )
                }
            }
        }

        // underline
        ThinLine(
            isFocused = isFocused
        )
    }
}
