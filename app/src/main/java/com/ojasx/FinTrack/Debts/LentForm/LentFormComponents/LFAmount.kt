package com.ojasx.FinTrack.Debts.LentForm.LentFormComponents

import com.ojasx.FinTrack.ThinLine
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates.TemplateComponents.DialogAmountTemplate
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
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
import com.ojasx.FinTrack.Debts.LentForm.LentViewModel

@Composable
fun LFAmountField(lentViewModel : LentViewModel) {
    // Observe amount from ViewModel (default to 0)
    val amount by lentViewModel.amount.observeAsState(initial = 0)
    var showDialog by remember { mutableStateOf(false) }
    var isFocused by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 8.dp)
    ) {

        // Top label
        Text(
            text = "Amount in INR",
            color = Color.Gray,
            fontWeight = FontWeight.Medium
        )

        // Display amount (clickable)
        Text(
            text = amount.toString(),
            style = LocalTextStyle.current.copy(fontSize = 20.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { showDialog = true }
        )

        Spacer(Modifier.height(4.dp))

        //UnderLine
        ThinLine(isFocused = isFocused)

        if (showDialog) {
            DialogAmountTemplate(
                onDismiss = { showDialog = false },
                onInsert = { value ->
                    // Update ViewModel with integer value (or 0 if invalid)
                    val parsed = value.toIntOrNull() ?: 0
                    lentViewModel.updateAmount(parsed)
                    showDialog = false
                }
            )
        }
    }
}
