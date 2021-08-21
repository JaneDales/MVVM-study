package com.janedales.mvvm_first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _counter: MutableLiveData<Int> = MutableLiveData(0)
    val counter: LiveData<Int> = _counter

    private val _showToast: MutableLiveData<Boolean> = MutableLiveData(false)
    val showToast: LiveData<Boolean> = _showToast

    private val _list: MutableLiveData<List<String>> = MutableLiveData(arrayListOf())
    val list: LiveData<List<String>> = _list

    fun increaseCount(i: Int) {
        val newValue = counter.value!! + i

        _showToast.value = newValue == 3
        _counter.value = newValue

        if (newValue == 5){
            _list.value = arrayListOf("Ann", "Sam", "Dean")
        }
    }
}