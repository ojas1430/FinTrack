package com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents

import android.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ojasx.wallet_clone.ui.theme.walletblue
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.AlertDialog
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ojasx.wallet_clone.ui.theme.walletblue
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kotlin.math.max
import kotlin.math.min

@Preview
@Composable
fun WarrantyPicker() {
    var showDialog by remember { mutableStateOf(false) }
    var selectedMonth by remember { mutableStateOf(12) } // default warranty
    val minMonth = 1
    val maxMonth = 120

    Spacer(Modifier.height(6.dp))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
    ) {
        Text(
            text = "Warranty",
            color = Color.Gray,
            fontWeight = FontWeight.Medium
        )
        Spacer(Modifier.height(4.dp))

        // Simple Text (clickable)
        Text(
            text = "$selectedMonth months",
            fontSize = 20.sp,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.clickable { showDialog = true }
        )

        // Dialog
        if (showDialog) {
            Dialog(onDismissRequest = { showDialog = false }) {
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    tonalElevation = 4.dp
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Choose warranty period (months)",
                            style = MaterialTheme.typography.titleMedium,
                            color = walletblue
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Simple number picker simulation
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            TextButton(onClick = {
                                selectedMonth = max(minMonth, selectedMonth - 1)
                            }) {
                                Text("-",
                                    fontSize = 20.sp)
                            }

                            Text(
                                text = "$selectedMonth",
                                style = MaterialTheme.typography.headlineMedium
                            )

                            TextButton(onClick = {
                                selectedMonth = min(maxMonth, selectedMonth + 1)
                            }) {
                                Text("+",
                                    fontSize = 20.sp)
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            TextButton(onClick = {
                                selectedMonth = 0
                                showDialog = false
                            }) {
                                Text("NONE",
                                    color = walletblue)
                            }
                            TextButton(onClick = { showDialog = false }) {
                                Text("CANCEL", color = walletblue)
                            }
                            TextButton(onClick = { showDialog = false }) {
                                Text("OK", color = walletblue)
                            }
                        }
                    }
                }
            }
        }
        Spacer(Modifier.height(4.dp))
        // underline
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp)
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
    }
}
