package me.fonix232.tipyapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import me.fonix232.tipyapp.db.dao.*
import me.fonix232.tipyapp.model.*

@Database(entities = [User::class, Post::class, Comment::class, Album::class, Photo::class, Todo::class], version = 1)
abstract class TipyDb: RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "people.db"
        val MIGRATIONS: List<Migration> = listOf()
    }

    abstract fun users(): UserDao
    abstract fun posts(): PostDao
    abstract fun comments(): CommentDao
    abstract fun albums(): AlbumDao
    abstract fun photos(): PhotoDao
    abstract fun todos(): TodoDao
}