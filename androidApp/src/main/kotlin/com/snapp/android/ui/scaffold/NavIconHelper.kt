package com.snapp.android.ui.scaffold

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

internal fun iconForName(name: String?): ImageVector {
    return when (name?.lowercase()) {
        "dashboard", "home" -> Icons.Default.Dashboard
        "account", "accounts", "customer", "customers", "person", "user" -> Icons.Default.AccountCircle
        "list", "orders", "records" -> Icons.Default.List
        else -> Icons.Default.MoreHoriz
    }
}

internal fun userMenuIconForName(name: String?): ImageVector {
    return when (name?.lowercase()) {
        "logout" -> Icons.Default.Logout
        "settings" -> Icons.Default.Settings
        "profile", "person", "user" -> Icons.Default.AccountCircle
        else -> Icons.Default.AccountCircle
    }
}
