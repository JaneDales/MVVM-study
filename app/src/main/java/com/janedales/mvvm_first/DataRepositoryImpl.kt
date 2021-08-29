package com.janedales.mvvm_first

class DataRepositoryImpl : DataRepository {

    override suspend fun getTodos(): List<Todo> {
        val api: ApiService = RetrofitInstance.getRetrofitInstance().create(ApiService::class.java)

        println("api === $api")
        val todos = api.getTodos()
        println("todos === $todos")
        return todos
    }

}