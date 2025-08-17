package com.ojasx.wallet_clone

import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ojasx.wallet_clone.ui.theme.walletblue

@Composable

fun StatusBarColor(color: Color) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = color,
            darkIcons = false
        )
        systemUiController.setSystemBarsColor(
            color = color,
            darkIcons = false
        )

    }
}