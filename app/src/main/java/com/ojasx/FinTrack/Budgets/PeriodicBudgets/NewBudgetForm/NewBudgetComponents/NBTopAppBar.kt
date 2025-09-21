package com.ojasx.FinTrack.Budgets.PeriodicBudgets.NewBudgetForm.NewBudgetComponents


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ojasx.FinTrack.Budgets.BudgetViewModel
import com.ojasx.FinTrack.ui.theme.walletblue
import com.ojasx.FinTrack.ui.theme.walletgreen

@Composable
fun NBTopAppBar(
    navController: NavController,
    budgetViewModel: BudgetViewModel
) {
    val colors = MaterialTheme.colorScheme

    TopAppBar(
        backgroundColor = colors.secondary,
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth(),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .height(80.dp)
                .statusBarsPadding(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            //back icon
            IconButton(
                onClick = {

                }
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "",
                    modifier = Modifier.size(30.dp),
                    tint = Color.White
                )
            }

            // Center
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "New budget",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )

            }

            IconButton(
                onClick = {
                    budgetViewModel.saveBudget()
                    navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "",
                    modifier = Modifier.size(30.dp),
                    tint = Color.White
                )
            }
        }
    }
}