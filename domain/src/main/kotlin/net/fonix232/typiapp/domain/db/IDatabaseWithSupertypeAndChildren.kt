package net.fonix232.typiapp.domain.db

import kotlinx.coroutines.flow.Flow
import net.fonix232.typiapp.domain.model.BaseModel

interface IDatabaseWithSupertypeAndChildren<T : BaseModel,T2 : BaseModel> : IDatabaseWithSupertype<T,T2> {
    fun getAllWithChildren(parent: T2): Flow<List<T>>
    fun getAllWithChildren(): Flow<List<T>>
    fun getWithChildren(id: Int): Flow<T>
}
