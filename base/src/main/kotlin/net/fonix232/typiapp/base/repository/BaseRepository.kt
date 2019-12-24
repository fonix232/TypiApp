package net.fonix232.typiapp.base.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import net.fonix232.typiapp.domain.client.NetworkResponse
import net.fonix232.typiapp.domain.model.BaseModel
import net.fonix232.typiapp.domain.repository.Repository
import org.koin.core.KoinComponent

abstract class BaseRepository<T: BaseModel>: Repository<T>, KoinComponent {

    override val items: LiveData<List<T>> by lazy {
        database.getAll().asLiveData()
    }

    override suspend fun sync() = coroutineScope<Unit> {
        // TODO: Set loading state true
        when(val result = client.getAll()) {
            is NetworkResponse.Success -> {
                // No need to notify the recipient
                withContext(Dispatchers.IO) { database.upsert(result.data) }
            }
            is NetworkResponse.NetworkFailure -> {
                // TODO: Set error field
                // This error only happens if there's no network connection
            }
            is NetworkResponse.ServerFailure -> {
                // TODO: Set error field
                // This error only happens if the user did something illegal
            }
        }
        // TODO: Set loading state false
    }

    override fun get(id: Int): T? = (items.value ?: listOf()).singleOrNull { it.id == id }

    override fun getLive(id: Int): LiveData<T?> = items.map { it.singleOrNull { it.id == id } }
}
