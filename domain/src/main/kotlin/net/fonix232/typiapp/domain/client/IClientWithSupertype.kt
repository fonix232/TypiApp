package net.fonix232.typiapp.domain.client

interface IClientWithSupertype<T,T2>: IClient<T> {
    suspend fun getAll(parent: T2): NetworkResponse<List<T>>
}
