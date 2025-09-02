package com.ojasx.FinTrack.Statistics.CashFlow

import androidx.compose.foundation.background
import com.ojasx.FinTrack.Statistics.Balance.getCurrentBalance
import com.ojasx.FinTrack.ui.theme.walletblue
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun CashFlowCard() {
    val CustomRed = Color(0xFFE62727)
    val CustomGreen = Color(0xFF48A14D)

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Cash Flow",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "Am I spending less than I make?",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
                Icon(
                    imageVector = androidx.compose.material.icons.Icons.Default.Share,
                    contentDescription = "Share",
                    tint = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Current Balance Display
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "NEXT 30 DAYS",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "₹0.00",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }

            Spacer(Modifier.height(16.dp))

            // Income
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Income", fontSize = 18.sp, color = Color.Black)
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = "₹0.00",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .height(22.dp)
                        .background(CustomGreen)
                )
                Spacer(Modifier.height(12.dp))
            }

            // Expenses
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Expenses", fontSize = 18.sp, color = Color.Black)
                Spacer(Modifier.weight(1f))
                Text(
                    text = "-₹0.00",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .height(22.dp)
                    .background(CustomRed)
            )
            Spacer(Modifier.height(12.dp))
        }
    }
}



