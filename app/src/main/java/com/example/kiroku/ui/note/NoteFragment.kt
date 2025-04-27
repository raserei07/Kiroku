package com.example.kiroku.ui.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import com.example.kiroku.ui.BaseFragment

class NoteFragment: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                SecondScreen()
            }
        }
    }
}

@Composable
fun SecondScreen() {
    Scaffold {
        Text(text = "This is the Note Fragment")
    }
}