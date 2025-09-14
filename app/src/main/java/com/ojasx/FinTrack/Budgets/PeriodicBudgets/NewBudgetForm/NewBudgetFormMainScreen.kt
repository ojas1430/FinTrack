package com.ojasx.FinTrack.Budgets.PeriodicBudgets.NewBudgetForm

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ojasx.FinTrack.Budgets.PeriodicBudgets.NewBudgetForm.NewBudgetComponents.NBTopAppBar
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.ui.tooling.preview.Preview
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
import com.ojasx.FinTrack.Budgets.BudgetViewModel
import com.ojasx.FinTrack.Budgets.PeriodicBudgets.NewBudgetForm.NewBudgetComponents.NBAmountField
import com.ojasx.FinTrack.Budgets.PeriodicBudgets.NewBudgetForm.NewBudgetComponents.NBCurrency
import com.ojasx.FinTrack.Budgets.PeriodicBudgets.NewBudgetForm.NewBudgetComponents.NBName
import com.ojasx.FinTrack.Budgets.PeriodicBudgets.NewBudgetForm.NewBudgetComponents.NBNotificationsCard
import com.ojasx.FinTrack.Budgets.PeriodicBudgets.NewBudgetForm.NewBudgetComponents.NBPeriod
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates.TemplateComponents.NoteTemplate
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates.TemplateComponents.PayeeTemplate
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates.TemplateComponents.PaymentTemplate
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates.TemplateComponents.PlaceTemplate
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates.TemplateComponents.TypeTemplate
import com.ojasx.FinTrack.ui.theme.walletgreen

@Composable
fun NewBudgetFormMainScreen(
    navController: NavController,
    budgetViewModel: BudgetViewModel
){

    // Set status bar color once
    StatusBarColor()

    Scaffold(
        topBar = { NBTopAppBar(navController,budgetViewModel) },
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            item { NBName(budgetViewModel) }
            item { NBAmountField(budgetViewModel) }
            item { NBPeriod(budgetViewModel) }
            item { NBCurrency() }
            item { NBNotificationsCard() }
        }
    }
}
