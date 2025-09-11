package com.ojasx.FinTrack.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.AccountSelection.AccountSelection
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Calculator
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonScreen
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Category.CardComposable.SubCategoryCards.FoodScreen
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Category.CardComposable.SubCategoryCards.Housing
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Category.CardComposable.SubCategoryCards.MainViewModel
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Category.CardComposable.SubCategoryCards.Shopping
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Category.CategoryScreen
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates.TemplateComponents.CategoryTemplate
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates.TemplateMainScreen
import com.ojasx.FinTrack.Records.ListOfRecords
import com.ojasx.FinTrack.Records.RecordsViewModel
import com.ojasx.FinTrack.Screens.HomeScreen.HomeScreen
import com.ojasx.FinTrack.SideBar.UserProfile.ProfileViewModel
import com.ojasx.FinTrack.SideBar.UserProfile.UserProfileScreen
import com.ojasx.FinTrack.Statistics.Balance.BalanceMainScreen
import com.ojasx.FinTrack.Statistics.Balance.BalancePoint
import com.ojasx.FinTrack.Statistics.StatisticsMainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val mainViewModel: MainViewModel = viewModel()
    val recordsviewModel : RecordsViewModel = viewModel()
    val profileviewmodel : ProfileViewModel = viewModel()


    NavHost(
        navController = navController, startDestination = "HomeScreen", builder = {

            // navitgates to cash account
            composable("Calculator-Account-Screen"){
                AccountSelection(navController)
            }

            //Home Screen
            composable("HomeScreen"){
                HomeScreen(navController,recordsviewModel,profileviewmodel)
            }

            //calculator screen
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
                ListOfRecords(navController,recordsviewModel)
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

            // Statistics main screen
            composable("StatisticsMainScreen"){
                StatisticsMainScreen(recordsviewModel)
            }

            // Records Main Screen
            composable("RecordsMainScreen"){
                ListOfRecords(navController,recordsviewModel)
            }

            // side screen user profile
            composable("UserProfileScreen"){
                UserProfileScreen(navController,profileviewmodel)
            }


        }

    )
}