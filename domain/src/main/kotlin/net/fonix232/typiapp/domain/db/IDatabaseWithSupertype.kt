package net.fonix232.typiapp.domain.db

import kotlinx.coroutines.flow.Flow
import net.fonix232.typiapp.domain.model.BaseModel

interface IDatabaseWithSupertype<T : BaseModel,T2 : BaseModel>: IDatabase<T> {
    fun getAll(parent: T2): Flow<List<T>>
}
