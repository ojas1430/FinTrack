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
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Templates.TemplateComponents.CategoryTemplate
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Templates.TemplateMainScreen
import com.ojasx.wallet_clone.Records.ListOfRecords
import com.ojasx.wallet_clone.Records.RecordsViewModel
import com.ojasx.wallet_clone.Screens.HomeScreen.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val mainViewModel: MainViewModel = viewModel()
    val recordsviewModel : RecordsViewModel = viewModel()


    NavHost(
        navController = navController, startDestination = "HomeScreen", builder = {
            // navitgates to cash account
            composable("Calculator-Account-Screen"){
                AccountSelection(navController)
            }
            composable("HomeScreen"){
                HomeScreen(navController)
            }

            composable("CalculatorScreen"){
                Calculator(navController,mainViewModel,recordsviewModel)
            }

            //navigates to side button screen
            composable("SideButton"){
                SideButtonScreen(navController)
            }

            // the new template screen opens
            composable("TemplatesScreenCreation"){
                TemplateMainScreen(navController)
            }

            // navigates to all types of categories
            composable("Category"){
                CategoryScreen(navController,mainViewModel)
            }

            //navigates to list of records screen
            composable("ListOfRecords"){
                ListOfRecords(recordsviewModel)
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
            composable("Categorytemplate"){
                CategoryTemplate(navController,mainViewModel)
            }

        }

    )
}