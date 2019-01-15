package me.fonix232.tipyapp.db.dao

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Flowable
import me.fonix232.tipyapp.common.UpsertDao
import me.fonix232.tipyapp.model.Photo

@Dao
abstract class PhotoDao: UpsertDao<Photo> {
    @Query("select * from photos order by id asc")
    abstract override fun getAll(): Flowable<List<Photo>>

    @Query("select * from photos where album_id is :albumId order by id asc")
    abstract fun getAll(albumId: Int): Flowable<List<Photo>>

    @Query("select * from photos where id is :id")
    abstract override fun get(id: Int): Flowable<Photo>

    @Query("delete from photos")
    abstract override fun deleteAll()
}