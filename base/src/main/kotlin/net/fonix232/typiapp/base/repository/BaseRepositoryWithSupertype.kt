package net.fonix232.typiapp.base.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import net.fonix232.typiapp.domain.model.BaseModel
import net.fonix232.typiapp.domain.repository.RepositoryWithSupertype

abstract class BaseRepositoryWithSupertype<T : BaseModel, T2 : BaseModel> :
    BaseRepository<T>(),
    RepositoryWithSupertype<T, T2> {

    override val parent: LiveData<T2?> = MutableLiveData(null)

    override val items: LiveData<List<T>> =
        parent.switchMap { it?.let { database.getAll(it).asLiveData() } ?: MutableLiveData() }

    override fun setCurrentParent(parent: T2?) {
        (this.parent as MutableLiveData).postValue(parent)
    }
}
