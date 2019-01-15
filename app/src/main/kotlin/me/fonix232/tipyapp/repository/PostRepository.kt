package me.fonix232.tipyapp.repository

import io.reactivex.Flowable
import io.reactivex.Single
import me.fonix232.tipyapp.common.BaseRepository
import me.fonix232.tipyapp.model.Comment
import me.fonix232.tipyapp.model.Post
import me.fonix232.tipyapp.toLiveData
import org.koin.standalone.inject
import retrofit2.Response

class PostRepository : BaseRepository<Post>() {
    override val dao = db.posts()

    companion object {
        const val KEY_POSTS = "synk_posts_"
        const val KEY_POST = "sync_post_"
    }

    val posts = listResult.toLiveData()
    val post = singleResult.toLiveData()

    override fun fetchAllFromLocal(): Flowable<List<Post>> = dao.getAll(userId)

    override fun fetchSingleFromLocal(id: Int): Flowable<Post> = dao.get(id)

    override fun fetchAllFromRemote(): Single<Response<List<Post>>> = client.getPosts(userId)

    override fun fetchSingleFromRemote(id: Int): Single<Response<Post>> = client.getPost(id)

    override fun getSynkAllKey(): String = KEY_POSTS + userId

    override fun getSynkSingleKey(id: Int): String = KEY_POST + id

    fun fetchAll(userId: Int) {
        this.userId = userId
        fetchAll()
    }

    private var userId: Int = -1
}