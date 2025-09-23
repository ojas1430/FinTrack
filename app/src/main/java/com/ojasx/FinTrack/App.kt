// App.kt
package com.ojasx.FinTrack

import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.navigation.compose.rememberNavController
import FinTrackTheme
import com.ojasx.FinTrack.Navigation.Navigation

@Composable
fun App() {
    // ✅ Global dark mode state
    var darkTheme by remember { mutableStateOf(false) }
    var isBlurEnabled by remember { mutableStateOf(false) }

    // ✅ Remember NavController once for the whole app
    val navController = rememberNavController()

    FinTrackTheme(darkTheme = darkTheme) {
        Navigation(
            darkTheme = darkTheme,
            onToggleTheme = { darkTheme = !darkTheme },
            isBlurEnabled = isBlurEnabled,
            onBlurChanged = { isBlurEnabled = it }
        )
    }
}