package me.fonix232.tipyapp.db.dao

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Flowable
import me.fonix232.tipyapp.common.UpsertDao
import me.fonix232.tipyapp.model.Comment

@Dao
abstract class CommentDao: UpsertDao<Comment> {
    @Query("select * from comments order by id asc")
    abstract override fun getAll(): Flowable<List<Comment>>

    @Query("select * from comments where post_id is :postId order by id asc")
    abstract fun getAll(postId: Int): Flowable<List<Comment>>

    @Query("select * from comments where id is :id")
    abstract override fun get(id: Int): Flowable<Comment>

    @Query("delete from comments")
    abstract override fun deleteAll()
}