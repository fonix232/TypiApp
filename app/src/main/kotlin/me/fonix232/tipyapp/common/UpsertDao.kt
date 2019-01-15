package me.fonix232.tipyapp.common

import android.database.sqlite.SQLiteConstraintException
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import io.reactivex.Flowable

interface UpsertDao<T> {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertAll(entities: List<T>)

    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insert(entity: T)

    @Update(onConflict = OnConflictStrategy.FAIL)
    fun update(entity: T)

    @Delete()
    fun delete(entity: T)

    fun upsert(entity: T) {
        try {
            insert(entity)
        } catch (e: SQLiteConstraintException) {
            update(entity)
        }
    }

    fun deleteAll()
    fun getAll(): Flowable<List<T>>
    fun get(id: Int): Flowable<T>
}