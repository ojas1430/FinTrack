package com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.CalculatorSideButton

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.AttachmentsSidebutton
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.DateTimePicker
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.LabelSideButton
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.NoteTextField
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.PayeeSideButton
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.PaymentSidebutton
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.PlaceSidebutton
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.StatusSidebutton
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.TopAppBarSideButton
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.CalculatorSideButton.SideButtonComponents.WarrantyPicker
import com.ojasx.FinTrack.StatusBarColor
import com.ojasx.FinTrack.ui.theme.walletblue

@Composable
    fun SideButtonScreen(navController: NavController) {
        // Set status bar color once
        StatusBarColor()

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
