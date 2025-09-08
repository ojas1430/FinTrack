package com.ojasx.FinTrack.SideBar

import androidx.compose.foundation.layout.Column
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

data class DrawerItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

public val mainItems = listOf(
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
)

public val topItems = listOf(
    DrawerItem("Get Premium", Icons.Default.Star, "premium"),
    DrawerItem("Bank Sync", Icons.Default.AccountBalance, "bank_sync"),
    DrawerItem("Imports", Icons.Default.FileDownload, "imports")
)
