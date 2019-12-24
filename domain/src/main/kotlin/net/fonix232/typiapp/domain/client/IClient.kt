package net.fonix232.typiapp.domain.client

interface IClient<T> {
    suspend fun getAll(): NetworkResponse<List<T>>
    suspend fun get(id: Int): NetworkResponse<T>
}
