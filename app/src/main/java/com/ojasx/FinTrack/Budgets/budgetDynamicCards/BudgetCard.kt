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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween

@Preview
@Composable
fun BudgetCard() {
    val spent = 100054
    val budget = 90000
    val isOverBudget = spent > budget
    val progress = (spent.toFloat() / budget.toFloat()).coerceAtMost(1f)

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
            // Top heading
            Text(
                text = "This month",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Row with ₹ and summation
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "(₹)", style = MaterialTheme.typography.bodyLarge)
                Text(text = "$spent / $budget", style = MaterialTheme.typography.bodyLarge)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Big clickable section (Bud row + progress bar + arrow)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { }
                    .padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Left column with Bud + progress bar
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Bud",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                        Text(
                            text = "$spent / $budget",
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

                // ARROW BUTTON
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

            // Show more button
            TextButton(onClick = {  }) {
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
