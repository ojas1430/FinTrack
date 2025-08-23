package com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ojasx.wallet_clone.ui.theme.calculatorcolor
import com.ojasx.wallet_clone.ui.theme.walletblue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CardComposable.SubCategoryCards.MainViewModel
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Templates.TemplatesButton
import com.ojasx.wallet_clone.Records.RecordIcons
import com.ojasx.wallet_clone.Records.RecordsViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@Composable
fun Calculator(
    navController: NavController,
    viewModel: MainViewModel = viewModel(),
    recordsViewModel: RecordsViewModel = viewModel()
) {
    var selectedButton by remember { mutableStateOf("INCOME") }
    val category by viewModel.selectedTitle.observeAsState("Select Category")
    var amountWithSign by remember { mutableStateOf("") }
    val selectedIcon by viewModel.selectedIcon.observeAsState(null)


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(calculatorcolor)
                .padding(4.dp)
        ) {
            Spacer(Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(calculatorcolor),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                //Cross Button
                IconButton(
                    onClick = {
                        navController.navigate("HomeScreen")
                    },
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

                    // Tick button
                    IconButton(
                        onClick = {

                            recordsViewModel.addRecord(
                                title = category,
                                amount = amountWithSign,
                                date = getCurrentDateTime(),
                                icon = selectedIcon ?: RecordIcons.ELECTRONICS
                            )
                            navController.navigate("ListOfRecords")

                        },
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

            // Top 3 buttons
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                //Income Button
                Button(
                    onClick = { selectedButton = "INCOME" },
                    shape = RectangleShape,
                    modifier = Modifier
                        .weight(1f)
                        .border(width = 1.dp, color = walletblue),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedButton == "INCOME") walletblue else calculatorcolor
                    )
                ) {
                    Text("INCOME", fontWeight = FontWeight.Medium, color = Color.White)
                }

                //Expense Button
                Button(
                    onClick = { selectedButton = "EXPENSE" },
                    shape = RectangleShape,
                    modifier = Modifier
                        .weight(1f)
                        .border(width = 1.dp, color = walletblue),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedButton == "EXPENSE") walletblue else calculatorcolor
                    )
                ) {
                    Text("EXPENSE", fontWeight = FontWeight.Medium, color = Color.White)
                }

                //Transfer Button
                Button(
                    onClick = { selectedButton = "TRANSFER" },
                    shape = RectangleShape,
                    modifier = Modifier
                        .weight(1f)
                        .border(width = 1.dp, color = walletblue),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedButton == "TRANSFER") walletblue else calculatorcolor
                    )
                ) {
                    Text("TRANSFER", fontWeight = FontWeight.Medium, color = Color.White)
                }
            }

            Column(modifier = Modifier.background(walletblue)) {
                // templates button
                TemplatesButton(navController)

                Row {
                    // Account Selection Button
                    Button(
                        onClick = {
                            navController.navigate("Calculator-Account-Screen")
                        },
                        modifier = Modifier.weight(1f)
                            .border(1.dp, Color.White),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = walletblue
                        ), shape = RectangleShape
                    ) {
                        Column {
                            androidx.compose.material.Text(
                                "Account", fontSize = 12.sp,
                                color = Color.LightGray
                            )
                            androidx.compose.material.Text(
                                "CASH", fontSize = 16.sp, color = Color.White
                            )
                        }
                    }

                    // Category Selection Button
                    Button(
                        onClick = {
                            navController.navigate("Category")
                        },
                        modifier = Modifier.weight(1f)
                            .border(width = 1.dp, Color.White),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = walletblue
                        ), shape = RectangleShape
                    ) {
                        Column {
                            androidx.compose.material.Text(
                                "Category", fontSize = 12.sp,
                                color = Color.LightGray
                            )
                            androidx.compose.material.Text(
                                text = category,
                                fontSize = 16.sp,
                                color = Color.White,
                                maxLines = 1
                            )
                        }
                    }
                }

            }
            Spacer(Modifier.height(10.dp))

            // passing buttons here
            CalculatorButtons(viewModel = viewModel(), selectedButton, navController , onResultChange = {latestAmount ->
                amountWithSign = latestAmount } )

        }

    }


fun getCurrentDateTime(): String {
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a")
    return current.format(formatter)
}