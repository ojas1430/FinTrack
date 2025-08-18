package com.ojasx.wallet_clone.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.AccountSelection.AccountSelection
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Calculator
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonScreen
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CardComposable.SubCategoryCards.FoodScreen
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CardComposable.SubCategoryCards.Housing
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CardComposable.SubCategoryCards.MainViewModel
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CardComposable.SubCategoryCards.Shopping
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CategoryScreen
import com.ojasx.wallet_clone.Screens.HomeScreen.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val mainViewModel: MainViewModel = viewModel()


    NavHost(
        navController = navController, startDestination = "HomeScreen", builder = {
            composable("Calculator-Account-Screen"){
                AccountSelection(navController)
            }
            composable("HomeScreen"){
                HomeScreen(navController)
            }

            composable("CalculatorScreen"){
                Calculator(navController,mainViewModel)
            }

            //navigates to side button screen
            composable("SideButton"){
                SideButtonScreen(navController)
            }

            composable("Category"){
                CategoryScreen(navController,mainViewModel)
            }
            composable("GetFoodCards"){
                FoodScreen(navController,mainViewModel)
            }
            composable("getShoppingCards"){
                Shopping(navController,mainViewModel)
            }
            composable("getHousingCards"){
                Housing(navController,mainViewModel)
            }

        }

    )
}