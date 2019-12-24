package net.fonix232.typiapp.domain.repository

import androidx.lifecycle.LiveData
import net.fonix232.typiapp.domain.client.IClientWithSupertype
import net.fonix232.typiapp.domain.db.IDatabaseWithSupertype
import net.fonix232.typiapp.domain.model.BaseModel

interface RepositoryWithSupertype<T : BaseModel, T2 : BaseModel> : Repository<T> {
    override val client: IClientWithSupertype<T, T2>
    override val database: IDatabaseWithSupertype<T, T2>

    val parent: LiveData<T2?>

    fun setCurrentParent(parent: T2?)
}
