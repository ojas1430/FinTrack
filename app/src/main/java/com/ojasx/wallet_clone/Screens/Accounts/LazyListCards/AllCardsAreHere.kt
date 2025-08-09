package com.ojasx.wallet_clone.Screens.Accounts.LazyListCards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ojasx.wallet_clone.R

@Preview
@Composable
fun Card1() {
    Box(
        modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)
    ){
        Card (
            modifier = Modifier
                .fillMaxWidth().height(100.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(10.dp)
        ){
            Row(
                modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {

                // Image
                Image(
                    painter = painterResource(id = R.drawable.business),
                    contentDescription = "",
                    modifier = Modifier.size(50.dp)
                )
                Spacer(Modifier.width(10.dp))

                Column(
                    modifier = Modifier
                        .padding(6.dp)
                ) {
                    Text("FinTrack for your business",
                        fontWeight = FontWeight.Medium)

                    Spacer(Modifier.height(6.dp))

                    Text("A smart app designed for entrepreneurs and small business.",
                        color = Color.Gray)
                }
            }
        }
    }
}


@Preview
@Composable
fun Card2() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ){
        Card (
            modifier = Modifier
                .fillMaxWidth().height(100.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(10.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)) {

                // Image
                Image(
                    painter = painterResource(id = R.drawable.storage),
                    contentDescription = "",
                    modifier = Modifier.size(50.dp)
                )
                Spacer(Modifier.width(10.dp))

                Column(
                    modifier = Modifier
                        .padding(6.dp)
                ) {
                    Text("Keep Your Data Safe",
                        fontWeight = FontWeight.Medium)

                    Spacer(Modifier.height(6.dp))

                    Text("Your information is backed up securely and synced across all your devices, so you never lose track.",
                        color = Color.Gray)
                }
            }
        }
    }
}

@Preview
@Composable
fun Card3() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth().height(100.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                // Image
                Image(
                    painter = painterResource(id = R.drawable.countdown),
                    contentDescription = "",
                    modifier = Modifier.size(50.dp)
                )
                Spacer(Modifier.width(10.dp))

                Column(
                    modifier = Modifier
                        .padding(6.dp)
                ) {
                    Text(
                        "FinTrack Reminder",
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(Modifier.height(6.dp))

                    Text(
                        "Get alerts when you forget to record spending.",
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Card4() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth().height(100.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                // Image
                Image(
                    painter = painterResource(id = R.drawable.bank),
                    contentDescription = "",
                    modifier = Modifier.size(50.dp)
                )
                Spacer(Modifier.width(10.dp))

                Column(
                    modifier = Modifier
                        .padding(6.dp)
                ) {
                    Text(
                        "Add More Accounts",
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(Modifier.height(6.dp))

                    Text(
                        "Add accounts to match every part of your financial life.",
                        color = Color.Gray
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun Card5() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth().height(100.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                // Image
                Image(
                    painter = painterResource(id = R.drawable.calendar),
                    contentDescription = "",
                    modifier = Modifier.size(50.dp)
                )
                Spacer(Modifier.width(10.dp))

                Column(
                    modifier = Modifier
                        .padding(6.dp)
                ) {
                    Text(
                        "Schedule Payments",
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(Modifier.height(6.dp))

                    Text(
                        "Add upcoming payments and forecast your finances",
                        color = Color.Gray
                    )
                }
            }
        }
    }
}