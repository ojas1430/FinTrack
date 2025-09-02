package com.ojasx.FinTrack.Statistics.Balance

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import android.graphics.Color as AndroidColor
import android.graphics.Typeface
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import android.util.Log
import androidx.compose.foundation.background
import com.ojasx.FinTrack.ui.theme.walletblue
import kotlin.math.ceil

@Composable
fun BalanceByAccounts(
    history: List<BalancePoint>
) {
    Card(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Balance Trend",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "Do I have more money than before?",
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
        Column {
            Text(
                text = "₹${getCurrentBalance(history)}",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    "Cash",
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(Modifier.weight(1f))

                Text(
                    text = "₹${getCurrentBalance(history)}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(22.dp)
                    .background(walletblue)
            )
            Spacer(Modifier.height(12.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}