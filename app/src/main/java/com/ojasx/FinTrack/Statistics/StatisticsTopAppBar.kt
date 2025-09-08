package com.ojasx.FinTrack.Statistics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ojasx.FinTrack.ui.theme.walletgreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatisticsTopAppBar(navController: NavController) {
    Column {
        androidx.compose.material3.TopAppBar(
            // modifier = modifier.statusBarsPadding(),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = walletgreen,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Localized description",
                        tint = Color.White
                    )
                }

            },
            title = {
                Text(
                    "Statistics",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            },
        )

        //Passing Buttons here
        StatisticsTopAppbarLazyRowButtons()
    }
}

@Composable
fun StatisticsTopAppbarLazyRowButtons() {
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {

        //Balance button
        item {
            Button(
                onClick = { },
                shape = RectangleShape,
                modifier = Modifier
                    .height(40.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = walletgreen
                )
            ) {
                Text(text = "BALANCE")
            }
        }

        //OutlookButton
        item {
            Button(
                onClick = { },
                shape = RectangleShape,
                modifier = Modifier
                    .height(40.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = walletgreen
                )
            ) {
                Text(text = "OUTLOOK")
            }
        }

        //Cash flow Button
        item {
            Button(
                onClick = { },
                shape = RectangleShape,
                modifier = Modifier
                    .height(40.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = walletgreen
                )
            ) {
                Text(text = "CASH-FLOW")
            }
        }


        // Spending Button
        item {
            Button(
                onClick = { },
                shape = RectangleShape,
                modifier = Modifier
                    .height(40.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = walletgreen
                )
            ) {
                Text(text = "SPENDING")
            }
        }

        // Credit Button
        item {
            Button(
                onClick = { },
                shape = RectangleShape,
                modifier = Modifier
                    .height(40.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = walletgreen
                )
            ) {
                Text(text = "CREDIT")
            }
        }

        // Reports Button
        item {
            Button(
                onClick = { },
                shape = RectangleShape,
                modifier = Modifier
                    .height(40.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = walletgreen
                )
            ) {
                Text(text = "REPORTS")
            }
        }

        // Assets Button
        item {
            Button(
                onClick = { },
                shape = RectangleShape,
                modifier = Modifier
                    .height(40.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = walletgreen
                )
            ) {
                Text(text = "ASSETS")
            }
        }

    }
}

