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

package net.fonix232.typiapp.persistence

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import net.fonix232.typiapp.domain.db.*
import net.fonix232.typiapp.persistence.db.TypiDatabase
import net.fonix232.typiapp.persistence.impl.*
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.dsl.onClose

val module = module {
    single<TypiDatabase> {
        Room.databaseBuilder(androidContext(), TypiDatabase::class.java, Constants.DATABASE_NAME)
            .addMigrations(*TypiDatabase.MIGRATIONS)
            .addCallback(object : RoomDatabase.Callback() {
                override fun onOpen(db: SupportSQLiteDatabase) {
                    super.onOpen(db)
                    // TODO: Add possible cleanup
                }
            })
            .fallbackToDestructiveMigration()
            .build()
    } onClose {
        it?.close()
    }


    single<AlbumDatabase> { AlbumDatabaseImpl() }
    single<CommentDatabase> { CommentDatabaseImpl() }
    single<PhotoDatabase> { PhotoDatabaseImpl() }
    single<PostDatabase> { PostDatabaseImpl() }
    single<TodoDatabase> { TodoDatabaseImpl() }
    single<UserDatabase> { UserDatabaseImpl() }
}
