package com.example.kiroku.ui.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.navigation.NavController
import javax.inject.Inject
import javax.inject.Singleton

interface AppNavigator {
    // Single-Activity Compose Navigation
    fun navigateTo(navController: NavController, screen: Screen)
    fun popBackStack(navController: NavController): Boolean

    // Activity-to-Activity Navigation (Modular edgecases)
    fun launchActivity(context: Context, intent: Intent, finishCurrent: Boolean = false)
    fun <T : Activity> launchActivityClass(context: Context, activityClass: Class<T>, finishCurrent: Boolean = false)
}

@Singleton
class AppNavigatorImpl @Inject constructor() : AppNavigator {

    override fun navigateTo(navController: NavController, screen: Screen) {
        navController.navigate(screen.route)
    }

    override fun popBackStack(navController: NavController): Boolean {
        return navController.popBackStack()
    }

    override fun launchActivity(context: Context, intent: Intent, finishCurrent: Boolean) {
        context.startActivity(intent)
        if (finishCurrent && (context is Activity)) {
            context.finish()
        }
    }

    override fun <T : Activity> launchActivityClass(context: Context, activityClass: Class<T>, finishCurrent: Boolean) {
        val intent = Intent(context, activityClass)
        launchActivity(context, intent, finishCurrent)
    }
}
