package com.example.raionacademylvl3

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class SharedViewModel : ViewModel() {
    private val _counter = mutableStateOf(0)
    val counter: State<Int> get() = _counter

    fun incrementCounter() {
        _counter.value++
    }

    fun decrementCounter() {
        if (_counter.value > 0) _counter.value--
    }
}
