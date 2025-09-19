package com.ojasx.FinTrack.Records

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.ojasx.FinTrack.StatusBarColor
import com.ojasx.FinTrack.ui.theme.walletblue
import com.ojasx.FinTrack.ui.theme.walletgreen
import com.ojasx.FinTrack.ui.theme.warmwhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordsTopAppBar( viewModel: RecordsViewModel , navController: NavController) {
    // summation of all card values
    val records by viewModel.recordlist.observeAsState(emptyList())
    val total = records.sumOf { it.amount.toIntOrNull() ?: 0 }
    val colors = MaterialTheme.colorScheme



    // Set status bar color
    StatusBarColor()

    LargeTopAppBar(
        navigationIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 8.dp)
            ) {
                IconButton(onClick = {
                    navController.navigate("HomeScreen")
                }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Records",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
        },
        title = {
            //  Second row with weeks and total
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "LAST 12 WEEKS",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = warmwhite
                )
                Spacer(Modifier.weight(1f))
                Text(
                    text = "∑ ₹${if (total >= 0) "+$total" else total}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = warmwhite,
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = Color.White
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "More",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = colors.secondary)
    )
}
