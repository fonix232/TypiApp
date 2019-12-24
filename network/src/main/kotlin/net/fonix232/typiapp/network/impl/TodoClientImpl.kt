package net.fonix232.typiapp.network.impl

import net.fonix232.typiapp.domain.client.ErrorResponse
import net.fonix232.typiapp.domain.client.NetworkResponse
import net.fonix232.typiapp.domain.client.TodoClient
import net.fonix232.typiapp.domain.model.Todo
import net.fonix232.typiapp.domain.model.User
import net.fonix232.typiapp.network.api.TypiApi
import net.fonix232.typiapp.network.toDomain
import org.koin.core.KoinComponent
import org.koin.core.inject

internal class TodoClientImpl: TodoClient, KoinComponent {

    //region Dependency Injection
    val client: TypiApi by inject()
    //endregion

    override suspend fun getAll(parent: User): NetworkResponse<List<Todo>> {
        val response = client.getTodos(parent.id)
        return when(response.isSuccessful) {
            true -> NetworkResponse.Success(response.code(), response.body()?.map { it.toDomain() } ?: listOf())
            false -> NetworkResponse.ServerFailure(response.code(), ErrorResponse(response.errorBody()?.string()))
        }
    }

    override suspend fun getAll(): NetworkResponse<List<Todo>> {
        val response = client.getTodos()
        return when (response.isSuccessful) {
            true -> NetworkResponse.Success(response.code(), response.body()!!.map { it.toDomain() })
            false -> NetworkResponse.ServerFailure(response.code(), ErrorResponse(response.errorBody()?.string()))
        }
    }

    override suspend fun get(id: Int): NetworkResponse<Todo> {
        val response = client.getTodo(id)
        return when (response.isSuccessful) {
            true -> NetworkResponse.Success(response.code(), response.body()!!.toDomain())
            false -> NetworkResponse.ServerFailure(response.code(), ErrorResponse(response.errorBody()?.string()))
        }
    }

}
