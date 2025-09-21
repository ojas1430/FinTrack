package com.ojasx.FinTrack.Budgets.PeriodicBudgets.NewBudgetForm.NewBudgetComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ojasx.FinTrack.Budgets.BudgetViewModel
import com.ojasx.FinTrack.ThinLine
import com.ojasx.FinTrack.ui.theme.walletblue

@Composable
fun NBName(budgetViewModel: BudgetViewModel) {
    // observe the current name from ViewModel
    val name by budgetViewModel.name.observeAsState(initial = "")
    val colors = MaterialTheme.colorScheme
    var isFocused by remember { mutableStateOf(false) }

    Spacer(Modifier.height(12.dp))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
    ) {
        Text(
            text = "Name",
            color = if (isFocused) colors.primary else Color.Gray,
            fontWeight = FontWeight.Medium
        )

        BasicTextField(
            value = name,
            onValueChange = { newValue ->
                budgetViewModel.updateName(newValue)
            },
            singleLine = true,
            textStyle = LocalTextStyle.current.copy(
                color = colors.onBackground,
                fontSize = 20.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                }
                .padding(top = 6.dp, bottom = 16.dp),
            decorationBox = { innerTextField ->
                Column {
                    innerTextField()
                    Spacer(Modifier.height(4.dp))

                    //underline
                    ThinLine(
                        isFocused = isFocused
                    )
                }
            }
        )
    }
}
