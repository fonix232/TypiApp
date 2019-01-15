package me.fonix232.tipyapp.repository

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject
import me.fonix232.tipyapp.*
import me.fonix232.tipyapp.common.BaseRepository
import me.fonix232.tipyapp.common.Outcome
import me.fonix232.tipyapp.model.Comment
import me.fonix232.tipyapp.model.Post
import retrofit2.Response
import timber.log.Timber
import java.lang.Exception

class CommentRepository : BaseRepository<Comment>() {
    override val dao = db.comments()

    companion object {
        const val KEY_COMMENTS = "synk_comments_"
        const val KEY_COMMENT = "sync_comment_"
    }

    val comments = listResult.toLiveData()
    val comment = singleResult.toLiveData()

    override fun fetchAllFromLocal(): Flowable<List<Comment>> = dao.getAll(postId)

    override fun fetchSingleFromLocal(id: Int): Flowable<Comment> = dao.get(id)

    override fun fetchAllFromRemote(): Single<Response<List<Comment>>> = client.getComments(postId)

    override fun fetchSingleFromRemote(id: Int): Single<Response<Comment>> = client.getComment(id)

    override fun getSynkAllKey(): String = KEY_COMMENTS + postId

    override fun getSynkSingleKey(id: Int): String = KEY_COMMENT + id

    fun fetchAll(postId: Int) {
        this.postId = postId
        fetchAll()
    }

    private var postId: Int = -1
}