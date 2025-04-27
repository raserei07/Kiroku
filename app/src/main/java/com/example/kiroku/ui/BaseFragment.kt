package com.example.kiroku.ui

import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

abstract class BaseFragment : Fragment() {

    fun navigate(navToPageId: Int, popUpTo: String ,isInclusive: Boolean = false) {
        findNavController().navigate(
            navToPageId,
            null,
            NavOptions.Builder().setPopUpTo(popUpTo, inclusive = isInclusive).build()
        )
    }
}