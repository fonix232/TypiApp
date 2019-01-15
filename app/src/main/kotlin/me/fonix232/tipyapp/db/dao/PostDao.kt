package me.fonix232.tipyapp.db.dao

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Flowable
import me.fonix232.tipyapp.common.UpsertDao
import me.fonix232.tipyapp.model.Post

@Dao
abstract class PostDao: UpsertDao<Post> {
    @Query("select * from posts order by id asc")
    abstract override fun getAll(): Flowable<List<Post>>

    @Query("select * from posts where user_id is :userId order by id asc")
    abstract fun getAll(userId: Int): Flowable<List<Post>>

    @Query("select * from posts where id is :id")
    abstract override fun get(id: Int): Flowable<Post>

    @Query("delete from posts")
    abstract override fun deleteAll()
}