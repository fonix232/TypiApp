package me.fonix232.tipyapp.repository

import io.reactivex.Flowable
import io.reactivex.Single
import me.fonix232.tipyapp.common.BaseRepository
import me.fonix232.tipyapp.model.Album
import me.fonix232.tipyapp.model.Post
import me.fonix232.tipyapp.toLiveData
import retrofit2.Response

class AlbumRepository : BaseRepository<Album>() {
    override val dao = db.albums()

    companion object {
        const val KEY_POSTS = "synk_albums_"
        const val KEY_POST = "sync_album_"
    }

    val albums = listResult.toLiveData()
    val album = singleResult.toLiveData()

    override fun fetchAllFromLocal(): Flowable<List<Album>> = dao.getAll(userId)

    override fun fetchSingleFromLocal(id: Int): Flowable<Album> = dao.get(id)

    override fun fetchAllFromRemote(): Single<Response<List<Album>>> = client.getAlbums(userId)

    override fun fetchSingleFromRemote(id: Int): Single<Response<Album>> = client.getAlbum(id)

    override fun getSynkAllKey(): String = KEY_POSTS + userId

    override fun getSynkSingleKey(id: Int): String = KEY_POST + id

    fun fetchAll(userId: Int) {
        this.userId = userId
        fetchAll()
    }

    private var userId: Int = -1
}