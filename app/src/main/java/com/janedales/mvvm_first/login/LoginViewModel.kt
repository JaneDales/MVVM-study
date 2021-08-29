package com.janedales.mvvm_first.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){

    private val _successLogin: MutableLiveData<Boolean> = MutableLiveData()
    val successLogin: LiveData<Boolean> = _successLogin

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> = _error

    fun validate(email: String, password: String) {
        if(email == "" || password == ""){
            _error.value = "Fill in your email and password "
        }
        else if (!email.contains("@")) {
            _error.value = "@"
        }
        else {
            _successLogin.value = true
        }
    }
}