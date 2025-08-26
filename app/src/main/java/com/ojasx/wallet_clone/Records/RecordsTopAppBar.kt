package com.ojasx.wallet_clone.Records

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ojasx.wallet_clone.StatusBarColor
import com.ojasx.wallet_clone.ui.theme.walletblue
import com.ojasx.wallet_clone.ui.theme.warmwhite

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun RecordsTopAppBar() {
    val systemUiController = rememberSystemUiController()

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // Set status bar color
        StatusBarColor(walletblue)

        LargeTopAppBar(
            title = {
                Column {
                    Text(
                        text = "Records",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(4.dp))
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
                            text = "∑ ₹1000",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = warmwhite
                        )
                    }
                }
            },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu",
                        tint = Color.White
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
            colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = walletblue)
        )
    }
}
