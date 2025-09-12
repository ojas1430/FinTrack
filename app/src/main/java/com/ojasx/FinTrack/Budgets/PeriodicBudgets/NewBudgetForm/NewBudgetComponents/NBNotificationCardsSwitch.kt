package com.ojasx.FinTrack.Budgets.PeriodicBudgets.NewBudgetForm.NewBudgetComponents

import android.widget.Switch
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
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

@Composable
fun NotificationsCard() {
    var budgetSwitch by remember { mutableStateOf(false) }
    var riskSwitch by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Top Heading
        Text(
            text = "Notifications",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(12.dp))

        //Budget Overspent
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Budget overspent",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Notify when amount has exceeded the budget",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
            Switch(
                checked = budgetSwitch,
                onCheckedChange = { budgetSwitch = it }
            )
        }

        // Underline
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .height(2.dp)
                .drawBehind {
                    val strokeWidth = 1.dp.toPx()
                    val y = size.height - strokeWidth / 2
                    drawLine(
                        color = Color.LightGray,
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = strokeWidth
                    )
                }
        )

        Spacer(modifier = Modifier.height(8.dp))

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
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Notify when budget is trending to be overspent",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
            Switch(
                checked = riskSwitch,
                onCheckedChange = { riskSwitch = it }
            )
        }
    }
}
