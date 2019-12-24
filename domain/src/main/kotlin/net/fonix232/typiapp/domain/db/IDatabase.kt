package net.fonix232.typiapp.domain.db

import kotlinx.coroutines.flow.Flow
import net.fonix232.typiapp.domain.model.BaseModel

interface IDatabase<T : BaseModel> {
    fun getAll(): Flow<List<T>>
    fun get(id: Int): Flow<T>
    fun delete(id: Int)
    fun upsert(vararg data: T)
    fun upsert(data: List<T>)
}
