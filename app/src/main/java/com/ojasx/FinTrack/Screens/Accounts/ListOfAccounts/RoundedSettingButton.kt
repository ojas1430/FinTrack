package com.ojasx.FinTrack.Screens.Accounts.ListOfAccounts

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ojasx.FinTrack.ui.theme.walletblue


@Composable
fun RoundedSettingButton(){
    Box(
        modifier = Modifier
            .size(30.dp)
            .border(
                width = 2.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(8.dp)
            )
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ){
        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = "",
            tint = walletblue,
        )
    }
}
