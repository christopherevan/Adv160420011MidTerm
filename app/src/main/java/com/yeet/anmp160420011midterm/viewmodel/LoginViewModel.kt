package com.yeet.anmp160420011midterm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()
}