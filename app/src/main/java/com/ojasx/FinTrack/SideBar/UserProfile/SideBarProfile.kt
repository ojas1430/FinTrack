package com.ojasx.FinTrack.SideBar.UserProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ojasx.FinTrack.R
import com.ojasx.FinTrack.ui.theme.walletgreen

@Composable
fun SideBarProfileSection(
    navController: NavController,
    viewModel: ProfileViewModel
    ) {

    val firstName by viewModel.firstName.observeAsState("")
    val lastName by viewModel.lastName.observeAsState("")
    val email by viewModel.email.observeAsState("")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(walletgreen)
            .padding(16.dp)
            .clickable{
                navController.navigate("UserProfileScreen")
            },
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
                text = "$firstName $lastName",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = email,
                fontSize = 14.sp,
                color = Color.White
            )
        }
    }
}
