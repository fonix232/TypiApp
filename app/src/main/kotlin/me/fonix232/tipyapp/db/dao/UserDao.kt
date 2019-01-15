package me.fonix232.tipyapp.db.dao

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Flowable
import me.fonix232.tipyapp.common.UpsertDao
import me.fonix232.tipyapp.model.User

@Dao
abstract class UserDao: UpsertDao<User> {
    @Query("select * from users order by id asc")
    abstract override fun getAll(): Flowable<List<User>>

    @Query("select * from users where id is :id")
    abstract override fun get(id: Int): Flowable<User>

    @Query("delete from users")
    abstract override fun deleteAll()
}