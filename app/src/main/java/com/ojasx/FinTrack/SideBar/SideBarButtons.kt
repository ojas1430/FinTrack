package com.ojasx.FinTrack.SideBar

import androidx.compose.foundation.layout.Column
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class DrawerItem(
    val label: String,
    val icon: ImageVector,
    val route: String,
    val isSwitch : Boolean = false
)

val allItems = listOf(
    DrawerItem("Get Premium", Icons.Default.Star, "premium"),
    DrawerItem("Bank Sync", Icons.Default.AccountBalance, "bank_sync"),
    DrawerItem("Imports", Icons.Default.FileDownload, "imports"),
    DrawerItem("Home", Icons.Default.Home, "home"),
    DrawerItem("Records", Icons.Default.List, "records"),
    DrawerItem("Investments", Icons.Default.TrendingUp, "investments"),
    DrawerItem("Statistics", Icons.Default.BarChart, "statistics"),
    DrawerItem("Planned Payments", Icons.Default.Payments, "planned_payments"),
    DrawerItem("Budgets", Icons.Default.AccountBalanceWallet, "budgets"),
    DrawerItem("Debts", Icons.Default.MoneyOff, "debts"),
    DrawerItem("Goals", Icons.Default.Flag, "goals"),
    DrawerItem("Business", Icons.Default.Business, "business"),
    DrawerItem("Shopping List", Icons.Default.ShoppingCart, "shopping_list"),
    DrawerItem("Warranties", Icons.Default.Assignment, "warranties"),
    DrawerItem("Loyalty Cards", Icons.Default.CardMembership, "loyalty_cards"),
    DrawerItem("Currency Rates", Icons.Default.AttachMoney, "currency_rates"),
    DrawerItem("Group Sharing", Icons.Default.Group, "group_sharing"),
    DrawerItem("Other", Icons.Default.MoreHoriz, "other"),
    DrawerItem("Invite Friends", Icons.Default.PersonAdd, "invite_friends"),
    DrawerItem("Follow Us", Icons.Default.Favorite, "follow_us"),
    DrawerItem("Help", Icons.Default.Help, "help"),
    DrawerItem("Settings", Icons.Default.Settings, "settings"),

    )

val switchItems = listOf(
    DrawerItem("Dark Mode", Icons.Default.DarkMode, "", true),
    DrawerItem("Hide Amounts", Icons.Default.VisibilityOff, "", true)
)

fun getColor(label: String): Color {
    return when (label) {
        "Home" -> Color(0xFFAFB42B)
        "Records" -> Color(0xFFFFC107)
        "Investments" -> Color(0xFF2E7D32)
        "Statistics" -> Color(0xFF2E7D32)
        "Planned Payments" -> Color(0xFFFFC107)
        "Budgets" -> Color(0xFFD32F2F)
        "Debts" -> Color(0xFFD32F2F)
        "Goals" -> Color(0xFF2E7D32)
        "Business" -> Color(0xFF3949AB)
        "Shopping List" -> Color(0xFF7CB342)
        "Warranties" -> Color(0xFFFFC107)
        "Loyalty Cards" -> Color(0xFFD32F2F)
        "Currency Rates" -> Color(0xFFAFB42B)
        "Group Sharing" -> Color(0xFF3949AB)
        "Other" -> Color.Gray

        "Get Premium" -> Color(0xFFFFD700)
        "Bank Sync" -> Color(0xFF1565C0)
        "Imports" -> Color(0xFF1565C0)
        "Invite Friends" -> Color(0xFF3949AB)
        "Follow Us" -> Color(0xFFEF5350)
        "Help" -> Color(0xFF7CB342)
        "Settings" -> Color(0xFF546E7A)

        else -> Color.Black
    }
}


@Composable
fun ThinDivider() {
    Divider(
        color = Color.Gray,
        thickness = 0.8.dp,
        modifier = Modifier
    )
}
