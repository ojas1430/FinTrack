    package com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.CalculatorSideButton

    import androidx.compose.foundation.BorderStroke
    import androidx.compose.foundation.layout.PaddingValues
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.width
    import androidx.compose.material3.Button
    import androidx.compose.material3.ButtonDefaults
    import androidx.compose.material3.Icon
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.KeyboardArrowLeft
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.unit.dp
    import com.ojasx.FinTrack.ui.theme.walletblue

    import androidx.navigation.NavController

    @Composable
    fun SideButton(navController: NavController) {
            Button(
                onClick = {
                    navController.navigate("SideButton")
                },
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

