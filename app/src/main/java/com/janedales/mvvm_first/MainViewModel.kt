package com.janedales.mvvm_first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    private val repository: DataRepositoryImpl = DataRepositoryImpl()

    private val _counter: MutableLiveData<Int> = MutableLiveData(0)
    val counter: LiveData<Int> = _counter

    private val _showToast: MutableLiveData<Boolean> = MutableLiveData(false)
    val showToast: LiveData<Boolean> = _showToast

    private val _list: MutableLiveData<List<String>> = MutableLiveData(arrayListOf())
    val list: LiveData<List<String>> = _list

    private val _todos: MutableLiveData<List<Todo>> = MutableLiveData()
    val todos: LiveData<List<Todo>> = _todos

    fun increaseCount(i: Int) {
        getTodos()
        val newValue = _counter.value!! + i

        _showToast.value = newValue == 3
        _counter.value = newValue

        if (newValue == 5){
            _list.value = arrayListOf("Ann", "Sam", "Dean")
        }
    }

    fun getTodos() {
        viewModelScope.launch {
            val list: List<Todo> = repository.getTodos()
            _todos.postValue(list)
        }
    }
}