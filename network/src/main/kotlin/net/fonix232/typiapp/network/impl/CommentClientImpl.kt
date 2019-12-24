package net.fonix232.typiapp.network.impl

import net.fonix232.typiapp.domain.client.CommentClient
import net.fonix232.typiapp.domain.client.ErrorResponse
import net.fonix232.typiapp.domain.client.NetworkResponse
import net.fonix232.typiapp.domain.model.Comment
import net.fonix232.typiapp.domain.model.Post
import net.fonix232.typiapp.network.api.TypiApi
import net.fonix232.typiapp.network.toDomain
import org.koin.core.KoinComponent
import org.koin.core.inject

internal class CommentClientImpl: CommentClient, KoinComponent {

    //region Dependency Injection
    val client: TypiApi by inject()
    //endregion

    override suspend fun getAll(parent: Post): NetworkResponse<List<Comment>> {
        val response = client.getComments(parent.id)
        return when(response.isSuccessful) {
            true -> NetworkResponse.Success(response.code(), response.body()?.map { it.toDomain() } ?: listOf())
            false -> NetworkResponse.ServerFailure(response.code(), ErrorResponse(response.errorBody()?.string()))
        }
    }

    override suspend fun getAll(): NetworkResponse<List<Comment>> {
        val response = client.getComments()
        return when(response.isSuccessful) {
            true -> NetworkResponse.Success(response.code(), response.body()?.map { it.toDomain() } ?: listOf())
            false -> NetworkResponse.ServerFailure(response.code(), ErrorResponse(response.errorBody()?.string()))
        }
    }

    override suspend fun get(id: Int): NetworkResponse<Comment> {
        val response = client.getComment(id)
        return when (response.isSuccessful) {
            true -> NetworkResponse.Success(response.code(), response.body()!!.toDomain())
            false -> NetworkResponse.ServerFailure(response.code(), ErrorResponse(response.errorBody()?.string()))
        }
    }

}
