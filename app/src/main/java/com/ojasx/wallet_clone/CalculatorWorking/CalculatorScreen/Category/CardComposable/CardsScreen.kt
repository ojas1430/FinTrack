package com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CardComposable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CardComposable.SubCategoryCards.MainViewModel

@Composable
fun CardsScreen(
        navController: NavController,
        mainViewModel: MainViewModel = viewModel()
) {
        CardLazyList(
                cards = CardsData(),
                navController = navController,
                mainViewModel = mainViewModel
        )
}

@Preview
@Composable
fun CardsScreenPreview() {
        val navController = rememberNavController()
        CardsScreen(navController = navController)
}