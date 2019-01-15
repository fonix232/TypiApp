package me.fonix232.tipyapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import me.fonix232.common.viewmodel.BaseViewModel
import me.fonix232.tipyapp.repository.AlbumRepository
import me.fonix232.tipyapp.repository.PhotoRepository
import org.koin.standalone.inject

class AlbumViewModel : BaseViewModel() {
    private val albumRepo: AlbumRepository by inject()
    private val photoRepo: PhotoRepository by inject()

    private var postId = -1

    val isUpdating: LiveData<Boolean> = MediatorLiveData()
    val title: LiveData<String> = MediatorLiveData()

    init {
        // TODO: Add MediatorLiveData init
    }

    fun init(postId: Int) {
        this.postId = postId
        update()
    }

    fun update() {

    }
}