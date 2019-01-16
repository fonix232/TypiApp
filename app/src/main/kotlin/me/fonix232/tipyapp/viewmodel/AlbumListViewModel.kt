package me.fonix232.tipyapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import me.fonix232.common.viewmodel.BaseViewModel
import me.fonix232.tipyapp.common.Outcome
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
        (albums as MediatorLiveData).addSource(repo.albums) { outcome ->
            when(outcome) {
                is Outcome.Success -> albums.postValue(outcome.data)
            }
        }
        (title as MediatorLiveData).addSource(repo.albums) { outcome ->
            when (outcome) {
                is Outcome.Success -> title.postValue("Posts: ${outcome.data.size}")
                is Outcome.Failure -> title.postValue("Network failure")
                is Outcome.Progress -> if (outcome.loading) title.postValue("Loading...")
            }
        }
        (isUpdating as MediatorLiveData).addSource(repo.albums) { outcome ->
            when (outcome) {
                is Outcome.Progress -> isUpdating.postValue(outcome.loading)
            }
        }
    }

    fun init(userId: Int) {
        this.userId = userId
        update()
    }

    fun update() {
        repo.fetchAll(userId)
    }
}