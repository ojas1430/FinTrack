package com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.CalculatorSideButton

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.AttachmentsSidebutton
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.DateTimePicker
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.LabelSideButton
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.NoteTextField
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.PayeeSideButton
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.PaymentSidebutton
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.PlaceSidebutton
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.StatusSidebutton
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.TopAppBarSideButton
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.WarrantyPicker
import com.ojasx.wallet_clone.StatusBarColor
import com.ojasx.wallet_clone.ui.theme.walletblue

@Composable
    fun SideButtonScreen(navController: NavController) {
        // Set status bar color once
        StatusBarColor(walletblue)

        Scaffold(
            topBar = { TopAppBarSideButton(navController) },
            contentWindowInsets = WindowInsets(0, 0, 0, 0)
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier.padding(innerPadding)
            ) {
                item {
                    NoteTextField()
                }
                item {
                    LabelSideButton()
                }
                item {
                    PayeeSideButton()
                }
                item {
                    DateTimePicker()
                }
                item {
                    PaymentSidebutton()
                }
                item {
                    StatusSidebutton()
                }
                item{
                    WarrantyPicker()
                }
                item {
                    PlaceSidebutton()
                }
                item {
                    AttachmentsSidebutton()
                }
            }
        }
    }
