package me.fonix232.tipyapp.repository

import io.reactivex.Flowable
import io.reactivex.Single
import me.fonix232.tipyapp.common.BaseRepository
import me.fonix232.tipyapp.model.User
import me.fonix232.tipyapp.toLiveData
import retrofit2.Response

class UserRepository : BaseRepository<User>() {
    override val dao = db.users()

    companion object {
        const val KEY_USERS = "synk_users"
        const val KEY_USER = "synk_user_"
    }

    val users = listResult.toLiveData()
    val user = singleResult.toLiveData()

    override fun fetchAllFromLocal(): Flowable<List<User>> = dao.getAll()

    override fun fetchSingleFromLocal(id: Int): Flowable<User> = dao.get(id)

    override fun fetchAllFromRemote(): Single<Response<List<User>>> = client.getUsers()

    override fun fetchSingleFromRemote(id: Int): Single<Response<User>> = client.getUser(id)

    override fun getSynkAllKey(): String = KEY_USERS

    override fun getSynkSingleKey(id: Int): String = KEY_USER + id
}