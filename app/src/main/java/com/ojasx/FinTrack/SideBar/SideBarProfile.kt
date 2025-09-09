package com.ojasx.FinTrack.SideBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ojasx.FinTrack.R
import com.ojasx.FinTrack.StatusBarColor
import com.ojasx.FinTrack.ui.theme.walletgreen

@Composable
fun SideBarProfileSection() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(walletgreen)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Image
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground), // Replace with your profile image
            contentDescription = "Profile",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.width(12.dp))

        // Name + Subtitle
        Column {
            Text(
                text = "Ojas Choudhary",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                text = "My FinTrack",
                fontSize = 14.sp
            )
        }
    }
}
