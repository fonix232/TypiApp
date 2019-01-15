package me.fonix232.tipyapp.repository

import io.reactivex.Flowable
import io.reactivex.Single
import me.fonix232.tipyapp.common.BaseRepository
import me.fonix232.tipyapp.model.Photo
import me.fonix232.tipyapp.toLiveData
import retrofit2.Response

class PhotoRepository : BaseRepository<Photo>() {
    override val dao = db.photos()

    companion object {
        const val KEY_PHOTOS = "synk_photos_"
        const val KEY_PHOTO = "sync_photo_"
    }

    val posts = listResult.toLiveData()
    val post = singleResult.toLiveData()

    override fun fetchAllFromLocal(): Flowable<List<Photo>> = dao.getAll(albumId)

    override fun fetchSingleFromLocal(id: Int): Flowable<Photo> = dao.get(id)

    override fun fetchAllFromRemote(): Single<Response<List<Photo>>> = client.getPhotos(albumId)

    override fun fetchSingleFromRemote(id: Int): Single<Response<Photo>> = client.getPhoto(id)

    override fun getSynkAllKey(): String = KEY_PHOTOS + albumId

    override fun getSynkSingleKey(id: Int): String = KEY_PHOTO + id

    fun fetchAll(albumId: Int) {
        this.albumId = albumId
        fetchAll()
    }

    private var albumId: Int = -1
}