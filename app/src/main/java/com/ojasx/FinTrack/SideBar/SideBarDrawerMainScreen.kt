package com.ojasx.FinTrack.SideBar

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.sp
import com.ojasx.FinTrack.SideBar.UserProfile.SideBarProfileSection

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
                    item { SideBarProfileSection() }

                    items(allItems) { item ->
                        NavigationDrawerItem(
                            label = {
                                Text(
                                    item.label,
                                    fontSize = 18.sp,
                                    modifier = Modifier.padding(start = 12.dp)
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
                            item.label == "Other"
                        ) {
                            ThinDivider()
                        }
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
            label = { Text(item.label, fontSize = 18.sp,
                ) },
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

