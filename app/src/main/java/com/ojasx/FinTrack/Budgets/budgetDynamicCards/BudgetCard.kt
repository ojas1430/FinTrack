package com.ojasx.FinTrack.Budgets.budgetDynamicCards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.ui.unit.Dp

@Preview
@Composable
fun BudgetCard() {
    val spent = 100054
    val budget = 90000
    val isOverBudget = spent > budget
    val progress = (spent.toFloat() / budget.toFloat()).coerceAtMost(1f)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Heading
            Text(
                text = "This month",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Row with currency symbol and spent/budget
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "(₹)", style = MaterialTheme.typography.bodyLarge)
                Text(text = "$spent / $budget", style = MaterialTheme.typography.bodyLarge)
            }

            Spacer(Modifier.height(4.dp))

            // animated progress bar
            AnimatedThickProgressBar(
                progress = progress,
                color = if (isOverBudget) Color.Red else Color.Green
            )

            // Row with arrow icon
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {  }
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Go to details",
                    tint = Color.Gray
                )
            }

            // Show more button
            TextButton(onClick = {  }) {
                Text(text = "SHOW MORE", color = Color.Blue)
            }
        }
    }
}

@Composable
fun AnimatedThickProgressBar(
    progress: Float,
    color: Color,
    thickness: Dp = 14.dp
) {
    // Animate progress value
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = 800)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
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
