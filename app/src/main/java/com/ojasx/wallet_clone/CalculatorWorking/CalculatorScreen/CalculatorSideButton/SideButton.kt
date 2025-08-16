    package com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.CalculatorSideButton

    import androidx.compose.foundation.BorderStroke
    import androidx.compose.foundation.background
    import androidx.compose.foundation.border
    import androidx.compose.foundation.clickable
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.PaddingValues
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.offset
    import androidx.compose.foundation.layout.width
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material3.Button
    import androidx.compose.material3.ButtonDefaults
    import androidx.compose.material3.Icon
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
    import androidx.compose.material.icons.filled.KeyboardArrowLeft
    import androidx.compose.material.icons.filled.KeyboardArrowRight
    import androidx.compose.material3.SegmentedButtonDefaults.Icon
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import com.ojasx.wallet_clone.ui.theme.walletblue
    import androidx.compose.foundation.layout.*
    import androidx.compose.material3.*

    import androidx.compose.ui.unit.dp
    import com.ojasx.wallet_clone.ui.theme.walletblue

    @Preview
    @Composable
    fun SideButton() {
            Button(
                onClick = {},
                modifier = Modifier
                    .width(35.dp)
                    .height(80.dp)
                    ,
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(2.dp, walletblue)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Back",
                    tint = Color.Gray
                )
            }
        }

