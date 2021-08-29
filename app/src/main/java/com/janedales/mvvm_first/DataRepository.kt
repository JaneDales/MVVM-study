package com.janedales.mvvm_first

interface DataRepository {
    suspend fun getTodos(): List<Todo>
}