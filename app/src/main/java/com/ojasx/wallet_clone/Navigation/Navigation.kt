package com.ojasx.wallet_clone.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.AccountSelection.AccountSelection
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Calculator
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CardComposable.CardsData
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CardComposable.SubCategoryCards.FoodScreen
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CategoryScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()


    NavHost(
        navController = navController, startDestination = "CalculatorScreen", builder = {
            composable("Calculator-Account-Screen"){
                AccountSelection(navController)
            }
            composable("CalculatorScreen"){
                Calculator(navController)
            }

            composable("Category"){
                CategoryScreen(navController)
            }
            composable("GetFoodCards"){
                FoodScreen(navController)
            }

        }

    )
}