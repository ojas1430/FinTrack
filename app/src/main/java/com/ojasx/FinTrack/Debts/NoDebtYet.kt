package com.ojasx.FinTrack.Debts

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text
import com.ojasx.FinTrack.R

@Preview
@Composable
fun NoDebtsYet() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(Modifier.height(175.dp))

            Image(
                painter = painterResource(R.drawable.nodebt),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .aspectRatio(1f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Track what you lent and borrowed",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = androidx.compose.ui.graphics.Color(Color.BLACK)

            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Manage all your debts here.",
                fontSize = 16.sp,
                color = androidx.compose.ui.graphics.Color(Color.GRAY)
            )
            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Start with (+) to create first one.",
                fontSize = 16.sp,
                color = androidx.compose.ui.graphics.Color(Color.GRAY)
            )

        }
    }
}