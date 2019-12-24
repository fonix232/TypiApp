/*
 * This file is part of TypiApp (https://github.com/fonix232/TypiApp/)
 * Copyright (c) 2019 Jozsef Kiraly <fonix232@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package net.fonix232.typiapp.persistence.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import net.fonix232.typiapp.persistence.common.Converters
import net.fonix232.typiapp.persistence.dao.*
import net.fonix232.typiapp.persistence.model.*

@Database(
    entities = [Album::class, Comment::class, Photo::class, Post::class, Todo::class, User::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
internal abstract class TypiDatabase : RoomDatabase() {
    companion object {
        val MIGRATIONS = arrayOf<Migration>()
    }

    abstract val users: UserDao

    abstract val albums: AlbumDao
    abstract val photos: PhotoDao

    abstract val posts: PostDao
    abstract val comments: CommentDao

    abstract val todos: TodoDao
}
