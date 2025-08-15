package com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CardComposable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CardsScreen(navController: NavController) {
        CardLazyList(
                cards = CardsData(),
                navController = navController,
                )
}

@Preview
@Composable
fun CardsScreenPreview() {
        val navController = rememberNavController()
        CardsScreen(navController = navController)
}