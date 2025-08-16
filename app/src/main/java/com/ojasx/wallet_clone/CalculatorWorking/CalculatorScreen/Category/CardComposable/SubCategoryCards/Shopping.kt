package com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CardComposable.SubCategoryCards

import  androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CardComposable.CardStructure
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CardComposable.getFoodsCards
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CardComposable.getShoppingCards
import com.ojasx.wallet_clone.R
import com.ojasx.wallet_clone.ui.theme.warmwhite
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items


@Composable
fun Shopping(navController: NavController,
               viewModel: MainViewModel = viewModel()) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(warmwhite)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            // Back Button at the top
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        // Simple navigation back to calculator
                        navController.navigate("CalculatorScreen")
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    "Select Category",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
            }

            Spacer(Modifier.height(15.dp))

            Text(
                "GENERAL",
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 15.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.shopping),
                    contentDescription = "",
                    Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Shopping",
                    style = MaterialTheme.typography.h6
                )
            }

            Text(
                text = "SUBCATEGORIES",
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 15.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp)
            )
            Spacer(Modifier.height(12.dp))

            // Display each card with clickable behavior
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(getShoppingCards()) { card ->
                    CardStructure(
                        cardsDataClass = card,
                        navController = navController,
                        onClick = { clickedCard ->
                            viewModel.updateSelectedTitle(clickedCard.title)
                            navController.popBackStack()
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}
