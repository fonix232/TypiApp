package me.fonix232.tipyapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import me.fonix232.common.viewmodel.BaseViewModel
import me.fonix232.tipyapp.common.Outcome
import me.fonix232.tipyapp.model.Album
import me.fonix232.tipyapp.model.Photo
import me.fonix232.tipyapp.repository.AlbumRepository
import me.fonix232.tipyapp.repository.PhotoRepository
import org.koin.standalone.inject

class AlbumViewModel : BaseViewModel() {
    private val albumRepo: AlbumRepository by inject()
    private val photoRepo: PhotoRepository by inject()

    private var albumId = -1

    val isUpdating: LiveData<Boolean> = MediatorLiveData()
    val title: LiveData<String> = MediatorLiveData()
    val album: LiveData<Album> = MediatorLiveData()
    val photos: LiveData<List<Photo>> = MediatorLiveData()

    init {
        (photos as MediatorLiveData).addSource(photoRepo.photos) { outcome ->
            when (outcome) {
                is Outcome.Success -> photos.postValue(outcome.data)
            }
        }
        (album as MediatorLiveData).addSource(albumRepo.album) { outcome ->
            when(outcome) {
                is Outcome.Success -> album.postValue(outcome.data)
            }
        }
        (title as MediatorLiveData).addSource(albumRepo.album) { outcome ->
            when (outcome) {
                is Outcome.Success -> title.postValue(outcome.data.title)
                is Outcome.Failure -> title.postValue("Network failure")
                is Outcome.Progress -> if (outcome.loading) title.postValue("Loading...")
            }
        }
        (isUpdating as MediatorLiveData).addSource(photoRepo.photos) { outcome ->
            when (outcome) {
                is Outcome.Progress -> isUpdating.postValue(outcome.loading)
            }
        }
    }

    fun init(albumId: Int) {
        this.albumId = albumId
        update()
    }

    fun update() {
        albumRepo.fetchSingle(albumId)
        photoRepo.fetchAll(albumId)
    }
}