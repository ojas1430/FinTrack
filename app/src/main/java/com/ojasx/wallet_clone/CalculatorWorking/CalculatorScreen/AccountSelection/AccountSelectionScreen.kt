package com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.AccountSelection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.tv.material3.Card
import com.ojasx.wallet_clone.ui.theme.walletblue
import com.ojasx.wallet_clone.R

@Composable
fun AccountSelection(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Column {
            TopAppBar(
                backgroundColor = walletblue,
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth(),
                contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                        .height(80.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    IconButton(
                        onClick = {
                            navController.navigate("CalculatorScreen")
                        },
                        modifier = Modifier.align(Alignment.Bottom)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            modifier = Modifier.size(30.dp),
                            tint = Color.White
                        )
                    }

                    Spacer(Modifier.width(25.dp))

                    Text(
                        "Account",
                        style = TextStyle(
                            fontSize = 24.sp,
                            color = Color.White
                        ),
                        modifier = Modifier.align(Alignment.Bottom)
                    )

                    Spacer(Modifier.weight(1f))

                    IconButton(
                        onClick = {},
                        modifier = Modifier.align(Alignment.Bottom)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings",
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                    }
                }
            }

            // Place AccountCards
            AccountCards()

        }
        // Adding Plus Button
        PlusButton()
    }

}


            @Composable
            fun AccountCards() {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color.Gray)
                        .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.moneybag),
                            contentDescription = "Money Bag",
                            modifier = Modifier.size(48.dp)
                        )
                        Spacer(Modifier.width(20.dp))
                        Column {
                            Text("Cash")
                            Text("Cash", color = Color.Gray)
                        }
                    }
                }
            }
