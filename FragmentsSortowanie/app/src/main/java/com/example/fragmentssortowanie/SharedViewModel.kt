package com.example.fragmentssortowanie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _inputText = MutableLiveData<String>()
    val inputText: LiveData<String> get() = _inputText

    fun setInputText(input: String) {
        _inputText.value = input
    }
}