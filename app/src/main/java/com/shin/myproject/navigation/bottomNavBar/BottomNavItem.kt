package com.shin.myproject.navigation.bottomNavBar

import androidx.compose.ui.graphics.vector.ImageVector


data class BottomNavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String,
 )