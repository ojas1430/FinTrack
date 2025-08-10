package com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ojasx.wallet_clone.ui.theme.calculatorcolor
import com.ojasx.wallet_clone.ui.theme.walletblue


@Preview
@Composable
fun Calculator() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(calculatorcolor)
    ) {
        Spacer(Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(calculatorcolor),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .background(calculatorcolor)
                    .size(64.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.size(36.dp)
                )
            }
            IconButton(
                onClick = {},
                modifier = Modifier
                    .background(calculatorcolor)
                    .size(64.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.size(36.dp)
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {},
                shape = RectangleShape,
                modifier = Modifier
                    .weight(1f)
                    .border(width = 1.dp, color = walletblue),
                colors = ButtonDefaults.buttonColors(containerColor = calculatorcolor)
            ) {
                Text("INCOME", fontWeight = FontWeight.Medium, color = Color.White)
            }

            Button(
                onClick = {},
                shape = RectangleShape,
                modifier = Modifier
                    .weight(1f)
                    .border(width = 1.dp, color = walletblue),
                colors = ButtonDefaults.buttonColors(containerColor = calculatorcolor)
            ) {
                Text("EXPENSE", fontWeight = FontWeight.Medium, color = Color.White)
            }

            Button(
                onClick = {},
                shape = RectangleShape,
                modifier = Modifier
                    .weight(1f)
                    .border(width = 1.dp, color = walletblue),
                colors = ButtonDefaults.buttonColors(containerColor = calculatorcolor)
            ) {
                Text("TRANSFER", fontWeight = FontWeight.Medium, color = Color.White)
            }
        }
    }

    }


