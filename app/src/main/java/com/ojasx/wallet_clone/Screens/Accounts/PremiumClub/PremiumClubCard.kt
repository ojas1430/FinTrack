package com.ojasx.wallet_clone.Screens.Accounts.PremiumClub

import com.ojasx.wallet_clone.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.tv.material3.ButtonDefaults
import androidx.tv.material3.Icon
import com.ojasx.wallet_clone.ui.theme.premium
import com.ojasx.wallet_clone.ui.theme.purpleBlue
import androidx.compose.material3.ButtonColors


@Preview
@Composable
fun PremiumClubCard() {
    Card(modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
        contentColor = Color.Black,
        containerColor = Color.White
    ), elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(width = 1.dp,
            color = premium

            )
    ) {
        CardText()
    }
}
@Preview(showBackground = true)
@Composable
fun CardText() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.starimage),
                contentDescription = "",
                modifier = Modifier.size(45.dp),


            )
            Spacer(Modifier.width(5.dp))


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Join our Premium Club!",
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Join FinTrack Premium — Unlock powerful insights,\nautomate your finances. Cancel anytime.",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(10.dp))
                PremiumButton()
            }
        }
    }
}

@Composable
fun PremiumButton() {
    Button(
        onClick = {},
        shape = RoundedCornerShape(8.dp),
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = premium
        )
    ) {
        Text("GET FINTRACK PREMIUM", color = Color.White,
            fontWeight = FontWeight.Medium)
    }
}