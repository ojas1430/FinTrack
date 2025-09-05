package com.ojasx.FinTrack.Statistics.Outlook

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import android.graphics.Color
import java.util.Map.entry

@Composable
fun BalanceForecastChart(
    modifier: Modifier = Modifier,
    entries: List<ForecastEntry>
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            BarChart(context).apply {
                description.isEnabled = false
                axisRight.isEnabled = false
                setFitBars(true)
                legend.isEnabled = false
                setScaleEnabled(false)
                setDrawGridBackground(false)
            }
        },
        update = { chart ->
            val barEntries = entries.mapIndexed { index, item ->
                BarEntry(index.toFloat(), item.value.toFloat())
            }

            val colors = entries.map {
                when (it.type) {
                    EntryType.NEGATIVE -> Color.RED
                    EntryType.POSITIVE -> Color.GREEN
                    EntryType.FORECAST -> Color.BLUE
                    EntryType.STARTING_BALANCE -> if (it.value >= 0) Color.GREEN else Color.RED
                }
            }

            val dataSet = BarDataSet(barEntries, "Balance Forecast").apply {
                setDrawValues(true)
                valueTextSize = 12f
                valueTextColor = Color.BLACK
                this.colors = colors
                valueFormatter = object : ValueFormatter() {
                    override fun getFormattedValue(value: Float): String = "₹${value.toInt()}"
                }
            }

            chart.data = BarData(dataSet).apply { barWidth = 0.6f }

            chart.xAxis.apply {
                position = XAxis.XAxisPosition.BOTTOM
                setDrawGridLines(false)
                valueFormatter = IndexAxisValueFormatter(entries.map { it.label })
                granularity = 1f
                textColor = Color.DKGRAY
            }

            chart.axisLeft.apply {
                setDrawGridLines(true)
                gridColor = Color.LTGRAY
                textColor = Color.DKGRAY

                if (entries.isNotEmpty()) {
                    val minValue = entries.minOf { it.value.toFloat() }
                    val maxValue = entries.maxOf { it.value.toFloat() }
                    val span = maxValue - minValue
                    val padding = (if (span > 0f) span else 100f) * 0.2f
                    axisMinimum = (minValue - padding).coerceAtMost(0f)
                    axisMaximum = (maxValue + padding).coerceAtLeast(0f)
                } else {
                    axisMinimum = -100f
                    axisMaximum = 100f
                }

                setDrawZeroLine(true)
                zeroLineColor = Color.BLACK
                zeroLineWidth = 1f
            }

            chart.invalidate()
        }
    )
}

