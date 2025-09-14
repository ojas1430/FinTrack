package com.ojasx.FinTrack.Budgets.budgetDynamicCards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import com.ojasx.FinTrack.Budgets.BudgetViewModel
import com.ojasx.FinTrack.Records.RecordsViewModel

@Composable
fun BudgetCard(
    budgetViewModel: BudgetViewModel,
    viewModel: RecordsViewModel
) {
    val name by budgetViewModel.name.observeAsState(initial = "My Budget")
    val amount by budgetViewModel.amount.observeAsState(initial = 0)
    val period by budgetViewModel.period.observeAsState(initial = "Monthly")

    // summation of all card amount
    val records by viewModel.recordlist.observeAsState(emptyList())
    val total = records.sumOf { it.amount.toIntOrNull() ?: 0 }

    val spent = "$total"
    val isOverBudget = spent > amount.toString()
    val progress = if (amount > 0) (spent.toFloat() / amount.toFloat()).coerceAtMost(1f) else 0f

    val arrowColor = Color.Blue
    val budgetTextColor = if (isOverBudget) Color.Red else Color.Green

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Top heading uses ViewModel data
            Text(
                text = "$period - $name",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "(₹)", style = MaterialTheme.typography.bodyLarge)
                Text(text = "$spent / $amount", style = MaterialTheme.typography.bodyLarge)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { }
                    .padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "$name",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                        Text(
                            text = "$spent / $amount",
                            style = MaterialTheme.typography.bodyMedium,
                            color = budgetTextColor
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    AnimatedThickProgressBar(
                        progress = progress,
                        color = budgetTextColor,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Box(
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .background(arrowColor.copy(alpha = 0.1f), RoundedCornerShape(10.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowForward,
                        contentDescription = "Go to details",
                        tint = arrowColor,
                        modifier = Modifier.size(28.dp)
                    )
                }
            }

            TextButton(onClick = { }) {
                Text(text = "SHOW MORE", color = arrowColor)
            }
        }
    }
}

@Composable
fun AnimatedThickProgressBar(
    progress: Float,
    color: Color,
    thickness: Dp = 14.dp,
    modifier: Modifier = Modifier
) {
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = 800)
    )

    Box(
        modifier = modifier
            .height(thickness)
            .background(Color.LightGray, RoundedCornerShape(50))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(animatedProgress)
                .height(thickness)
                .background(color, RoundedCornerShape(50))
        )
    }
}
