package net.fonix232.typiapp.network.impl

import net.fonix232.typiapp.domain.client.ErrorResponse
import net.fonix232.typiapp.domain.client.NetworkResponse
import net.fonix232.typiapp.domain.client.PhotoClient
import net.fonix232.typiapp.domain.model.Album
import net.fonix232.typiapp.domain.model.Photo
import net.fonix232.typiapp.network.api.TypiApi
import net.fonix232.typiapp.network.toDomain
import org.koin.core.KoinComponent
import org.koin.core.inject

internal class PhotoClientImpl: PhotoClient, KoinComponent {

    //region Dependency Injection
    val client: TypiApi by inject()
    //endregion

    override suspend fun getAll(parent: Album): NetworkResponse<List<Photo>> {
        val response = client.getPhotos(parent.id)
        return when(response.isSuccessful) {
            true -> NetworkResponse.Success(response.code(), response.body()?.map { it.toDomain() } ?: listOf())
            false -> NetworkResponse.ServerFailure(response.code(), ErrorResponse(response.errorBody()?.string()))
        }
    }

    override suspend fun getAll(): NetworkResponse<List<Photo>> {
        val response = client.getPhotos()
        return when (response.isSuccessful) {
            true -> NetworkResponse.Success(response.code(), response.body()!!.map { it.toDomain() })
            false -> NetworkResponse.ServerFailure(response.code(), ErrorResponse(response.errorBody()?.string()))
        }
    }

    override suspend fun get(id: Int): NetworkResponse<Photo> {
        val response = client.getPhoto(id)
        return when (response.isSuccessful) {
            true -> NetworkResponse.Success(response.code(), response.body()!!.toDomain())
            false -> NetworkResponse.ServerFailure(response.code(), ErrorResponse(response.errorBody()?.string()))
        }
    }

}
