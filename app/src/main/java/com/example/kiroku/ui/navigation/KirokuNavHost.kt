package com.example.kiroku.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kiroku.ui.dashboard.DashboardScreen
import com.example.kiroku.ui.dashboard.DashboardViewModel
import com.example.kiroku.ui.note.NoteScreen
import com.example.kiroku.ui.note.NoteViewModel

@Composable
fun KirokuNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Dashboard.route,
        modifier = modifier
    ) {
        composable(Screen.Dashboard.route) {
            val dashboardViewModel: DashboardViewModel = hiltViewModel()
            DashboardScreen(
                viewModel = dashboardViewModel,
                onNavigateToNotes = {
                    navController.navigate(Screen.Notes.route)
                }
            )
        }
        composable(Screen.Notes.route) {
            val noteViewModel: NoteViewModel = hiltViewModel()
            NoteScreen(
                viewModel = noteViewModel,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
