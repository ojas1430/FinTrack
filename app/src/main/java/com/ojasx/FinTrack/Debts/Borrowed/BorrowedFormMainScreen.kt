package com.ojasx.FinTrack.Debts.Borrowed

import BorrowedViewModel
import com.ojasx.FinTrack.Debts.LentForm.LentViewModel
import com.ojasx.FinTrack.Debts.LentForm.LentFormComponents.LFAccount
import com.ojasx.FinTrack.Debts.LentForm.LentFormComponents.LFDate
import com.ojasx.FinTrack.Debts.LentForm.LentFormComponents.LFDescription
import com.ojasx.FinTrack.Debts.LentForm.LentFormComponents.LFDueDate
import com.ojasx.FinTrack.Debts.LentForm.LentFormComponents.LFName
import com.ojasx.FinTrack.Debts.LentForm.LentFormComponents.LentFormTopAppBarCode
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
import com.ojasx.FinTrack.Debts.Borrowed.BorrowedFormComponents.BFAccount
import com.ojasx.FinTrack.Debts.Borrowed.BorrowedFormComponents.BFAmountField
import com.ojasx.FinTrack.Debts.Borrowed.BorrowedFormComponents.BFDate
import com.ojasx.FinTrack.Debts.Borrowed.BorrowedFormComponents.BFDescription
import com.ojasx.FinTrack.Debts.Borrowed.BorrowedFormComponents.BFDueDate
import com.ojasx.FinTrack.Debts.Borrowed.BorrowedFormComponents.BFName
import com.ojasx.FinTrack.Debts.Borrowed.BorrowedFormComponents.BFTopAppBarCode
import com.ojasx.FinTrack.ui.theme.walletgreen

@Composable
fun BFFormMainScreen(
    navController: NavController,
    borrowedViewModel: BorrowedViewModel
    ){

    // Set status bar color once
    StatusBarColor()

    Scaffold(
        topBar = { BFTopAppBarCode(navController) },
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            item { BFName(borrowedViewModel) }
            item { BFDescription(borrowedViewModel) }
            item { BFAccount(borrowedViewModel) }
            item { BFAmountField(borrowedViewModel) }
            item { BFDate() }
            item { BFDueDate() }
        }
    }
}
