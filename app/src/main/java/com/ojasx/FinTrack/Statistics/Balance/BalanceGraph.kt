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
import com.ojasx.FinTrack.ui.theme.walletblue
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.ceil


@Composable
fun BalanceGraph(
    history: List<BalancePoint>,
    modifier: Modifier = Modifier
) {
    val today = LocalDate.now(ZoneId.of("Asia/Kolkata"))
    val startDate = today.minusDays(3) // 29 Aug 2025 if today is 1 Sep 2025
    val totalDays = 3 // Covers 4 days (indices 0 to 3: 29 Aug to 1 Sep)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(400.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
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
                    text = "TODAY",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = "₹${getCurrentBalance(history)}",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = walletblue //Color(0xFF2196F3)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Chart Container
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .padding(4.dp)
            ) {
                AndroidView(
                    factory = { context ->
                        LineChart(context).apply {
                            description.isEnabled = false
                            legend.isEnabled = false

                            xAxis.apply {
                                position = XAxis.XAxisPosition.BOTTOM
                                setDrawGridLines(false)
                                setDrawLabels(true)
                                textSize = 10f
                                textColor = AndroidColor.BLACK
                                setDrawAxisLine(false)
                                setTypeface(Typeface.DEFAULT_BOLD)
                                setLabelCount(4, true)
                                granularity = 1f
                                axisMinimum = 0f
                                axisMaximum = totalDays.toFloat()
                                yOffset = 20f


                                valueFormatter = object : ValueFormatter() {
                                    private val formatter = DateTimeFormatter.ofPattern("d MMM")

                                    override fun getFormattedValue(value: Float): String {
                                        Log.d("ChartDebug", "Formatter value: $value")
                                        val index = value.toInt().coerceIn(0, totalDays)
                                        val date = startDate.plusDays(index.toLong())
                                        Log.d("ChartDebug", "Index: $index, Date: ${date.format(formatter)}")
                                        return date.format(formatter)
                                    }
                                }
                            }

                            axisLeft.apply {
                                setDrawGridLines(true)
                                setDrawLabels(true)
                                textSize = 10f
                                textColor = AndroidColor.BLACK
                                gridColor = AndroidColor.LTGRAY
                                gridLineWidth = 1f
                                setDrawAxisLine(false)
                                setTypeface(Typeface.DEFAULT_BOLD)
                                setLabelCount(4, true)
                                axisMinimum = 0f
                                axisMaximum = if (history.isNotEmpty()) {
                                    getRoundedMaxValue(history.maxOf { it.balance }.toFloat())
                                } else {
                                    1000f
                                }
                                valueFormatter = object : ValueFormatter() {
                                    override fun getFormattedValue(value: Float): String {
                                        return formatYAxisValue(value.toInt())
                                    }
                                }
                            }

                            axisRight.isEnabled = false
                            setBackgroundColor(AndroidColor.WHITE)
                            setPadding(20, 20, 20, 20)
                            setDrawGridBackground(false)
                            setTouchEnabled(true)
                            setScaleEnabled(false)
                            setPinchZoom(false)
                            layoutParams = android.view.ViewGroup.LayoutParams(
                                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                                android.view.ViewGroup.LayoutParams.MATCH_PARENT
                            )
                        }
                    },
                    update = { chart ->
                        val entries = if (history.isEmpty()) {
                            emptyList<Entry>()
                        } else {
                            createRealData(history, startDate, totalDays)
                        }

                        if (entries.isNotEmpty()) {
                            val dataSet = LineDataSet(entries, "Balance").apply {
                                color = AndroidColor.parseColor("#4300FF");     // Blue shade
                                setCircleColor(AndroidColor.parseColor("#4300FF"));
                                lineWidth = 2f
                                //  circleRadius = f
                                setDrawValues(false)
                                setDrawCircles(true)
                                setDrawCircleHole(true)
                                circleHoleRadius = 5f
                                mode = LineDataSet.Mode.CUBIC_BEZIER
                                setDrawFilled(true)
                                fillColor = AndroidColor.parseColor("#802196F3")
                                fillAlpha = 100
                            }
                            chart.data = LineData(dataSet)
                        } else {
                            chart.clear()
                            chart.data = LineData()
                        }

                        chart.invalidate()
                        chart.post {
                            chart.invalidate()
                            chart.requestLayout()
                        }

                        // Log dataset for debugging
                        entries.forEach { Log.d("ChartDebug", "Entry x: ${it.x}, y: ${it.y}") }
                    }
                )
            }
        }
    }
}

fun getCurrentBalance(history: List<BalancePoint>): String {
    return if (history.isNotEmpty()) {
        val latest = history.maxByOrNull { it.date }
        val balance = latest?.balance ?: 0
        NumberFormat.getNumberInstance(Locale("en", "IN")).format(balance)
    } else {
        "0"
    }
}

private fun createRealData(history: List<BalancePoint>, startDate: LocalDate, totalDays: Int): List<Entry> {
    val balanceMap = history.associateBy { it.date }
    val entries = mutableListOf<Entry>()
    var lastBalance = 0

    // Generate entries for the last 4 days (29 Aug to 1 Sep)
    for (index in 0..totalDays) {
        val date = startDate.plusDays(index.toLong())
        val balance = balanceMap[date]?.balance ?: lastBalance
        lastBalance = balance
        entries.add(Entry(index.toFloat(), balance.toFloat()))
        Log.d("ChartDebug", "Date: $date, Index: $index, Balance: $balance")
    }

    return entries
}

private fun formatYAxisValue(value: Int): String {
    return when {
        value >= 1000000 -> "${(value / 1000000)}M"
        value >= 100000 -> "${(value / 100000)}L"
        value >= 1000 -> "${(value / 1000)}k"
        else -> value.toString()
    }
}

private fun getRoundedMaxValue(maxValue: Float): Float {
    return when {
        maxValue >= 1000000 -> ceil(maxValue / 1000000).toInt() * 1000000f
        maxValue >= 100000 -> ceil(maxValue / 100000).toInt() * 100000f
        maxValue >= 1000 -> ceil(maxValue / 1000).toInt() * 1000f
        else -> ceil(maxValue / 100).toInt() * 100f
    }
}