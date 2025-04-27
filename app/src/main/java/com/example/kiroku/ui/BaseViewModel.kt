package com.example.kiroku.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers

abstract class BaseViewModel : ViewModel() {
    val dispatcherIo by lazy { Dispatchers.IO }
    val dispatcherMain by lazy { Dispatchers.Main }
}