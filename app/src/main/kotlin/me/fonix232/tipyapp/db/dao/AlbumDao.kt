package me.fonix232.tipyapp.db.dao

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Flowable
import me.fonix232.tipyapp.common.UpsertDao
import me.fonix232.tipyapp.model.Album

@Dao
abstract class AlbumDao: UpsertDao<Album> {
    @Query("select * from albums order by id asc")
    abstract override fun getAll(): Flowable<List<Album>>

    @Query("select * from albums where user_id is :userId order by id asc")
    abstract fun getAll(userId: Int): Flowable<List<Album>>

    @Query("select * from albums where id is :id")
    abstract override fun get(id: Int): Flowable<Album>

    @Query("delete from albums")
    abstract override fun deleteAll()
}