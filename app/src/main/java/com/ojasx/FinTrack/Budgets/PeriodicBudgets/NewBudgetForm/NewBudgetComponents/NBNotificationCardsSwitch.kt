package com.ojasx.FinTrack.Budgets.PeriodicBudgets.NewBudgetForm.NewBudgetComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.scale
import androidx.core.content.contentValuesOf
import com.ojasx.FinTrack.ThinLine
import com.ojasx.FinTrack.ui.theme.walletblue

@Composable
fun NBNotificationsCard() {
    var colors = MaterialTheme.colorScheme
    var budgetSwitch by remember { mutableStateOf(false) }
    var riskSwitch by remember { mutableStateOf(false) }
    var isFocused by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Top Heading
        Text(
            text = "NOTIFICATIONS",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Budget Overspent
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Budget overspent",
                    style = MaterialTheme.typography.titleMedium,
                    color = colors.onBackground
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "Notify when amount has exceeded the budget",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
            Switch(
                checked = budgetSwitch,
                onCheckedChange = { budgetSwitch = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = colors.primary,
                    checkedTrackColor = colors.primary.copy(alpha = 0.5f)
                ),
                modifier = Modifier.scale(0.8f)
            )
        }
        Spacer(Modifier.height(2.dp))


        // Underline
        ThinLine(
            isFocused = isFocused
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Risk of Overspending
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Risk of overspending",
                    style = MaterialTheme.typography.titleMedium,
                    color = colors.onBackground
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "Notify when budget is trending to be overspent",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
            Switch(
                checked = riskSwitch,
                onCheckedChange = { riskSwitch = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = colors.onPrimary,
                    checkedTrackColor = colors.onPrimary.copy(alpha = 0.5f)
                ),
                modifier = Modifier.scale(0.8f)
            )
        }
        Spacer(Modifier.height(2.dp))

        // Underline
        ThinLine(
            isFocused = isFocused
        )
    }
}
