package com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.AccountSelection

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.tv.material3.Icon
import com.ojasx.wallet_clone.ui.theme.walletblue
import androidx.compose.foundation.layout.*
import androidx.compose.material.ModalDrawer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun PlusButton() {
    Box(modifier = Modifier.fillMaxSize().padding(30.dp),
        contentAlignment = Alignment.BottomEnd
    ){
        FloatingActionButton(
            onClick = {},
            shape = CircleShape,
            backgroundColor = walletblue,
            modifier = Modifier.size(70.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(34.dp)
            )
        }
    }
}