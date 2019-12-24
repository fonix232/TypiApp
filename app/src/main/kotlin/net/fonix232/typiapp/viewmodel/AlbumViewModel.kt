package net.fonix232.typiapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import net.fonix232.typiapp.base.viewmodel.BaseViewModel
import net.fonix232.typiapp.domain.model.Album
import net.fonix232.typiapp.domain.repository.AlbumRepository
import org.koin.core.inject

class AlbumViewModel: BaseViewModel() {

    //region Dependency Injection
    private val repo: AlbumRepository by inject()
    //endregion

    val albums: LiveData<List<Album>> = repo.items

    fun update() {
        viewModelScope.async { repo.sync() }
    }

}
