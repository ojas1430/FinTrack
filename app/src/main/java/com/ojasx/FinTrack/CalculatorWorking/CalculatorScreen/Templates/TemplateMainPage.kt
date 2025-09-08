package com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates


import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Category.CardComposable.SubCategoryCards.MainViewModel
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates.TemplateComponents.AccountTemplate
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates.TemplateComponents.AmountFieldTemplate
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates.TemplateComponents.CategoryTemplate
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates.TemplateComponents.TemplateName
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates.TemplateComponents.TopAppBarTemplate
import com.ojasx.FinTrack.StatusBarColor
import com.ojasx.FinTrack.ui.theme.walletblue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates.TemplateComponents.NoteTemplate
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates.TemplateComponents.PayeeTemplate
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates.TemplateComponents.PaymentTemplate
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates.TemplateComponents.PlaceTemplate
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates.TemplateComponents.TypeTemplate
import com.ojasx.FinTrack.ui.theme.walletgreen


@Composable
fun TemplateMainScreen(navController: NavController){
    val sharedViewModel: MainViewModel = viewModel()


    // Set status bar color once
    StatusBarColor(walletgreen)

    Scaffold(
        topBar = { TopAppBarTemplate(navController) },
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            item {
                TemplateName()
            }
            item {
                AmountFieldTemplate()
            }
            item {
                AccountTemplate(navController)
            }
            item {
                CategoryTemplate(navController, viewModel = viewModel<MainViewModel>())
            }
            item {
                PaymentTemplate()
            }
            item {
                NoteTemplate()
            }
            item {
                PayeeTemplate()
            }
            item {
                TypeTemplate()
            }
            item {
                PlaceTemplate()
            }
        }
    }
}
