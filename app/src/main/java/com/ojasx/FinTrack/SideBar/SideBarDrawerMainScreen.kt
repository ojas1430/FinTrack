package com.ojasx.FinTrack.SideBar

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ojasx.FinTrack.SideBar.UserProfile.ProfileViewModel
import com.ojasx.FinTrack.SideBar.UserProfile.SideBarProfileSection
import com.ojasx.FinTrack.ui.theme.walletgreen


@Composable
fun ModalSidebar(
    drawerState: DrawerState,
    isDarkMode: Boolean,
    onThemeToggle: () -> Unit,
    onNavigate: (String) -> Unit,
    navController: NavController,
    profileViewModel: ProfileViewModel,
    content: @Composable (() -> Unit)

) {
    var theme by remember { mutableStateOf(false) }
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val drawerWidth = screenWidth * 0.8f
    val (selectedRoute, setSelectedRoute) = remember { mutableStateOf<String?>(null) }
    val colors = MaterialTheme.colorScheme

    val systemUiController = rememberSystemUiController()

    // StatusBar icons color to sidebar open/close
    LaunchedEffect(drawerState.isOpen) {
        if (drawerState.isOpen) {
            // Sidebar opened → dark icons
            systemUiController.setStatusBarColor(
                color = colors.background,
                darkIcons = true     // black icons
            )
        } else {
            // Sidebar closed → white icons
            systemUiController.setStatusBarColor(
                color = walletgreen,
                darkIcons = false
            )
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(drawerWidth),
                drawerContainerColor = colors.background,
                drawerContentColor = colors.onBackground
            ) {
                LazyColumn {
                    item { SideBarProfileSection(navController,profileViewModel) }

                    items(allItems) { item ->
                        NavigationDrawerItem(
                            label = {
                                Text(
                                    item.label,
                                    fontSize = 18.sp,
                                    modifier = Modifier.padding(start = 12.dp),
                                    color = colors.onBackground
                                )
                            },
                            selected = selectedRoute == item.route,
                            onClick = {
                                setSelectedRoute(item.route)
                                onNavigate(item.route)
                            },
                            icon = {
                                Icon(
                                    item.icon,
                                    contentDescription = item.label,
                                    tint = getColor(item.label),
                                    modifier = Modifier.size(24.dp)
                                )
                            },
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedTextColor = getColor(item.label),
                                unselectedTextColor = Color.Black,
                                selectedIconColor = getColor(item.label),
                                unselectedIconColor = getColor(item.label)
                            )
                        )

                        // Add thin divider after specific items
                        if (item.label == "Get Premium" ||
                            item.label == "Imports" ||
                            item.label == "Planned Payments" ||
                            item.label == "Other" ||
                            item.label == "Settings"
                        ) {
                            ThinDivider()
                        }
                    }

                    items(switchItems) { switch ->
                        SideBarSwitches(switchItem = switch)
                    }
                    item{
                        DarkModeSwitche(
                            isDarkMode = isDarkMode ,
                            onDarkModeChanged = {
                                onThemeToggle()
                            }
                        )
                    }

                }
            }
        }
    ) {
        content()
    }
}


@Composable
private fun DrawerSection(
    items: List<DrawerItem>,
    selectedRoute: String?,
    setSelectedRoute: (String) -> Unit,
    onNavigate: (String) -> Unit
) {
    items.forEach { item ->
        NavigationDrawerItem(
            label = { Text(item.label, fontSize = 18.sp,) },
            selected = selectedRoute == item.route,
            onClick = {
                setSelectedRoute(item.route)
                onNavigate(item.route)
            },
            icon = {
                Icon(item.icon,
                    contentDescription = item.label,
                    tint = getColor(item.label),
                    modifier = Modifier.size(24.dp)
                ) },
            colors = NavigationDrawerItemDefaults.colors()
        )
    }
}