package me.fonix232.tipyapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import me.fonix232.common.viewmodel.BaseViewModel
import me.fonix232.tipyapp.model.Album
import me.fonix232.tipyapp.repository.AlbumRepository
import org.koin.standalone.inject

class AlbumListViewModel: BaseViewModel() {
    private val repo: AlbumRepository by inject()

    private var userId: Int = -1

    val isUpdating: LiveData<Boolean> = MediatorLiveData()
    val title: LiveData<String> = MediatorLiveData()
    val albums: LiveData<List<Album>> = MediatorLiveData()

    init {
        // TODO: Add MediatorLiveData init
    }

    fun init(userId: Int) {
        this.userId = userId
        update()
    }

    fun update() {
        repo.fetchAll(userId)
    }
}