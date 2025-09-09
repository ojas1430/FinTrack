package com.ojasx.FinTrack

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ojasx.FinTrack.ui.theme.walletgreen

@Composable
fun StatusBarColor() {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = walletgreen,
            darkIcons = false
        )
        systemUiController.setSystemBarsColor(
            color = walletgreen,
            darkIcons = false
        )
    }
}