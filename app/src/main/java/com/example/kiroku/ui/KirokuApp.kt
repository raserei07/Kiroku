package com.example.kiroku.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.kiroku.ui.navigation.KirokuNavHost
import com.example.kiroku.ui.theme.KirokuTheme

@Composable
fun KirokuApp() {
    KirokuTheme {
        val navController = rememberNavController()
        Surface(modifier = Modifier.fillMaxSize()) {
            KirokuNavHost(navController = navController)
        }
    }
}
