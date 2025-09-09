package com.ojasx.FinTrack.SideBar

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.wear.compose.materialcore.screenWidthDp
import com.ojasx.FinTrack.StatusBarColor
import com.ojasx.FinTrack.ui.theme.walletblue

@Composable
fun ModalSidebar(
    drawerState: DrawerState,
    onNavigate: (String) -> Unit,
    content: @Composable () -> Unit
) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val drawerWidth = screenWidth * 0.8f
    val (selectedRoute, setSelectedRoute) = remember { mutableStateOf<String?>(null) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(drawerWidth),
                drawerContainerColor = Color.White,
                drawerContentColor = Color.Black
            ) {
                LazyColumn {
                    item {
                        SideBarProfileSection()
                    }
                    items(topItems) { item ->
                        NavigationDrawerItem(
                            label = { Text(item.label) },
                            selected = selectedRoute == item.route,
                            onClick = {
                                setSelectedRoute(item.route)
                                onNavigate(item.route)
                            },
                            icon = { Icon(item.icon, contentDescription = item.label) },
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedTextColor = walletblue,
                                unselectedTextColor = Color.Black,
                                selectedIconColor = walletblue,
                                unselectedIconColor = Color.Black
                            )
                        )
                    }
                    items(mainItems) { item ->
                        NavigationDrawerItem(
                            label = { Text(item.label) },
                            selected = selectedRoute == item.route,
                            onClick = {
                                setSelectedRoute(item.route)
                                onNavigate(item.route)
                            },
                            icon = { Icon(item.icon, contentDescription = item.label) },
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedTextColor = Color.Black,
                                unselectedTextColor = Color.Black,
                                selectedIconColor = Color.Black,
                                unselectedIconColor = Color.Black
                            )
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
            label = { Text(item.label) },
            selected = selectedRoute == item.route,
            onClick = {
                setSelectedRoute(item.route)
                onNavigate(item.route)
            },
            icon = { Icon(item.icon, contentDescription = item.label) },
            colors = NavigationDrawerItemDefaults.colors()
        )
    }
}