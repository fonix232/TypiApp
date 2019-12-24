package net.fonix232.typiapp.domain.repository

import net.fonix232.typiapp.domain.db.IDatabaseWithSupertypeAndChildren
import net.fonix232.typiapp.domain.model.BaseModel

interface RepositoryWithSupertypeAndChildren<T : BaseModel, T2 : BaseModel> : RepositoryWithSupertype<T, T2> {
    override val database: IDatabaseWithSupertypeAndChildren<T, T2>
}
