package com.ojasx.wallet_clone.Screens.HomeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Icon
import com.ojasx.wallet_clone.ui.theme.walletblue

@Composable
fun FloatingButton(modifier: Modifier) {
        FloatingActionButton(
            onClick = {},
            shape = CircleShape,
            backgroundColor = walletblue,
            modifier = Modifier.size(60.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(34.dp)
            )
        }
    }
