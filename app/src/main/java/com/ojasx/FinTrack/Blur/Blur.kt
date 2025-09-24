package com.ojasx.FinTrack.Blur

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp

@Composable
fun BlurElement(
    isBlur: Boolean,
    content: @Composable () -> Unit
) {
    Box(
        modifier = if (isBlur) Modifier.blur(12.dp) else Modifier
    ) {
        content()
    }
}
