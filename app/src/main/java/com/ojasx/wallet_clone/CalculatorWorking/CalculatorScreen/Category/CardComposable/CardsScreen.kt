package com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CardComposable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun CardsScreen() {
    val navController = rememberNavController()
        CardLazyList(CardsData(),navController = navController)
}