package com.example.kiroku.ui.navigation

sealed class Screen(val route: String, val title: String) {
    data object Dashboard : Screen("dashboard", "Dashboard")
    data object Notes : Screen("notes", "Notes")
    data object NoteDetail : Screen("note/{noteId}", "Note Detail") {
        fun createRoute(noteId: Long) = "note/$noteId"
    }
    data object AddTransaction : Screen("transaction/add", "Add Transaction")
    data object Settings : Screen("settings", "Settings")
}
