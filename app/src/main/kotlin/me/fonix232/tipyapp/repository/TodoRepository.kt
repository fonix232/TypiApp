package me.fonix232.tipyapp.repository

import io.reactivex.Flowable
import io.reactivex.Single
import me.fonix232.tipyapp.common.BaseRepository
import me.fonix232.tipyapp.model.Post
import me.fonix232.tipyapp.model.Todo
import me.fonix232.tipyapp.toLiveData
import retrofit2.Response

class TodoRepository: BaseRepository<Todo>() {
    override val dao = db.todos()

    companion object {
        const val KEY_TODOS = "synk_todos_"
        const val KEY_TODO = "sync_todo_"
    }

    val todos = listResult.toLiveData()
    val todo = singleResult.toLiveData()

    override fun fetchAllFromLocal(): Flowable<List<Todo>> = dao.getAll(userId)

    override fun fetchSingleFromLocal(id: Int): Flowable<Todo> = dao.get(id)

    override fun fetchAllFromRemote(): Single<Response<List<Todo>>> = client.getTodos(userId)

    override fun fetchSingleFromRemote(id: Int): Single<Response<Todo>> = client.getTodo(id)

    override fun getSynkAllKey(): String = KEY_TODOS + userId

    override fun getSynkSingleKey(id: Int): String = KEY_TODO + id

    fun fetchAll(userId: Int) {
        this.userId = userId
        fetchAll()
    }

    private var userId: Int = -1
}