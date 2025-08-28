package com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Templates

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ojasx.FinTrack.ui.theme.walletblue


// This button is the Templates button on calculator screen
@Composable
fun TemplatesButton(navController: NavController) {
    Button(
        onClick = {
            navController.navigate("TemplatesScreenCreation")
        },
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, Color.LightGray),
        colors = ButtonDefaults.buttonColors(
            containerColor = walletblue
        ),
        shape = RectangleShape
    ) {
        Text(
            text = "TEMPLATES", 
            style = TextStyle(
                color = Color.White
            )
        )
    }
}