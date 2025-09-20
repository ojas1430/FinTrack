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
import androidx.compose.ui.graphics.RectangleShape
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
fun RecordsTopAppBar(viewModel: RecordsViewModel, navController: NavController) {
    val records by viewModel.recordlist.observeAsState(emptyList())
    val total = records.sumOf { it.amount.toIntOrNull() ?: 0 }
    val colors = MaterialTheme.colorScheme

    // Set status bar color
    StatusBarColor()

    Column {
        // Normal TopAppBar
        TopAppBar(
            title = {
                Text(
                    text = "Records",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            },
            navigationIcon = {
                IconButton(onClick = { navController.navigate("HomeScreen") }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu",
                        tint = Color.White
                    )
                }
            },
            actions = {
                IconButton(onClick = {  }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                }
                IconButton(onClick = {  }) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "More",
                        tint = Color.White
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = colors.secondary
            )
        )

        // Row with rectangular buttons
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { /*TODO*/ },
                shape = RectangleShape,
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = colors.secondary
                )
            ) {
                Text(text = "LAST 12 WEEKS")
            }
            Button(
                onClick = {  },
                shape = RectangleShape,
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = colors.secondary
                )
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "∑ ₹${if (total >= 0) "+$total" else total}",
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )
                }
            }

        }
    }
}
