package net.fonix232.typiapp.network.impl

import net.fonix232.typiapp.domain.client.ErrorResponse
import net.fonix232.typiapp.domain.client.NetworkResponse
import net.fonix232.typiapp.domain.client.UserClient
import net.fonix232.typiapp.domain.model.User
import net.fonix232.typiapp.network.api.TypiApi
import net.fonix232.typiapp.network.toDomain
import org.koin.core.KoinComponent
import org.koin.core.inject

internal class UserClientImpl : UserClient, KoinComponent {

    //region Dependency Injection
    val client: TypiApi by inject()
    //endregion

    override suspend fun getAll(): NetworkResponse<List<User>> {
        val response = client.getUsers()
        return when (response.isSuccessful) {
            true -> NetworkResponse.Success(response.code(), response.body()!!.map { it.toDomain() })
            false -> NetworkResponse.ServerFailure(response.code(), ErrorResponse(response.errorBody()?.string()))
        }
    }

    override suspend fun get(id: Int): NetworkResponse<User> {
        val response = client.getUser(id)
        return when (response.isSuccessful) {
            true -> NetworkResponse.Success(response.code(), response.body()!!.toDomain())
            false -> NetworkResponse.ServerFailure(response.code(), ErrorResponse(response.errorBody()?.string()))
        }
    }

}
