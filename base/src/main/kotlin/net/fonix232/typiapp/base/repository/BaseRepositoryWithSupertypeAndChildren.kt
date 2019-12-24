package net.fonix232.typiapp.base.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import net.fonix232.typiapp.domain.model.BaseModel
import net.fonix232.typiapp.domain.repository.RepositoryWithSupertypeAndChildren

abstract class BaseRepositoryWithSupertypeAndChildren<T : BaseModel, T2 : BaseModel> :
    BaseRepositoryWithSupertype<T, T2>(),
    RepositoryWithSupertypeAndChildren<T, T2> {

    override val items: LiveData<List<T>> =
        parent.switchMap { it?.let { database.getAllWithChildren(it).asLiveData() } ?: MutableLiveData() }

}
