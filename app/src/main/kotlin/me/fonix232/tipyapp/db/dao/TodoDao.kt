package me.fonix232.tipyapp.db.dao

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Flowable
import me.fonix232.tipyapp.common.UpsertDao
import me.fonix232.tipyapp.model.Todo

@Dao
abstract class TodoDao: UpsertDao<Todo> {
    @Query("select * from todos order by id asc")
    abstract override fun getAll(): Flowable<List<Todo>>

    @Query("select * from todos where user_id is :userId order by id asc")
    abstract fun getAll(userId: Int): Flowable<List<Todo>>

    @Query("select * from todos where id is :id")
    abstract override fun get(id: Int): Flowable<Todo>

    @Query("delete from todos")
    abstract override fun deleteAll()
}