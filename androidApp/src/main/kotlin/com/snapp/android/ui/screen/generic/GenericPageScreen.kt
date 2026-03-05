package com.snapp.android.ui.screen.generic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.snapp.android.ui.navigation.LocalSnappNavigation
import com.snapp.android.ui.navigation.navigateToRecord
import com.snapp.android.ui.navigation.navigateToReports
import com.snapp.android.viewmodel.AuthViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun GenericPageScreen(
    title: String,
    authViewModel: AuthViewModel = koinViewModel()
) {
    val navController = LocalSnappNavigation.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.navigateToRecord("101") }) {
            Text("Go To Details (ID: 101)")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigateToReports() }) {
            Text("Go To Reports")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { authViewModel.logout() }) {
            Text("Logout")
        }
    }
}
