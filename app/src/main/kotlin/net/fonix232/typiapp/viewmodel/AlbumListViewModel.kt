package net.fonix232.typiapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import net.fonix232.typiapp.base.viewmodel.BaseViewModel
import net.fonix232.typiapp.domain.model.Album
import net.fonix232.typiapp.domain.model.User
import net.fonix232.typiapp.domain.repository.AlbumRepository
import net.fonix232.typiapp.domain.repository.UserRepository
import org.koin.core.inject

class AlbumListViewModel : BaseViewModel() {

    //region Dependency Injection
    private val userRepo: UserRepository by inject()
    private val repo: AlbumRepository by inject()
    //endregion

    private val userId: LiveData<Int?> = MutableLiveData(null)
    private val user: LiveData<User?> = userId.map { it?.let { userRepo.get(it).also { repo.setCurrentParent(it) } } }

    val albums: LiveData<List<Album>> = repo.items

    fun update() {
        viewModelScope.async { repo.sync() }
    }

    fun init(userId: Int) {
        (this.userId as MutableLiveData).postValue(userId)
    }
}
