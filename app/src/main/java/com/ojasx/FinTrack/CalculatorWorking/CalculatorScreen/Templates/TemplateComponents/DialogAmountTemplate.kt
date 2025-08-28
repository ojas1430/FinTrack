package com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates.TemplateComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ojasx.FinTrack.ui.theme.walletblue

@Composable
fun DialogAmountTemplate(
    onDismiss: () -> Unit,
    onInsert: (String) -> Unit
) {
    var input by remember { mutableStateOf("0") }

    androidx.compose.material.AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text("Enter Amount", color = walletblue) },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                // Display row with value + backspace
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = input,
                        fontSize = 24.sp,
                        modifier = Modifier.weight(1f),
                        color = walletblue
                    )

                    IconButton(onClick = {
                        input = if (input.length > 1) {
                            input.dropLast(1)
                        } else {
                            "0"
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Backspace",
                            tint = walletblue
                        )
                    }
                }

                Spacer(Modifier.height(12.dp))

                // Keypad grid
                val buttons = listOf(
                    listOf("7", "8", "9"),
                    listOf("4", "5", "6"),
                    listOf("1", "2", "3"),
                    listOf(".", "0")
                )

                buttons.forEach { row ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        row.forEach { label ->
                            Button(
                                onClick = {
                                    input = if (input == "0") label else input + label
                                },
                                modifier = Modifier
                                    .padding(4.dp)
                                    .weight(1f),
                                colors = androidx.compose.material.ButtonDefaults.buttonColors(
                                    backgroundColor = androidx.compose.ui.graphics.Color.LightGray
                                )
                            ) {
                                Text(label)
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = { onInsert(input) }) {
                Text("INSERT", color = walletblue)
            }
        },
        dismissButton = {
            Row {
                TextButton(onClick = { input = "0" }) {
                    Text("CLEAR", color = walletblue)
                }
                TextButton(onClick = { onDismiss() }) {
                    Text("CANCEL", color = walletblue)
                }
            }
        }
    )
}

