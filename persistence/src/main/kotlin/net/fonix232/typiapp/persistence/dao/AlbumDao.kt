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

package net.fonix232.typiapp.persistence.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import net.fonix232.typiapp.persistence.Constants
import net.fonix232.typiapp.persistence.common.BaseDao
import net.fonix232.typiapp.persistence.model.Album
import net.fonix232.typiapp.persistence.model.AlbumWithPhotos

@Dao
internal abstract class AlbumDao : BaseDao<Album>() {
    @Query("select * from ${Constants.TableNames.ALBUM}")
    abstract fun getAll(): Flow<List<Album>>

    @Query("select * from ${Constants.TableNames.ALBUM} where ${Constants.ColumnNames.USER_ID} == :userId")
    abstract fun getAll(userId: Int): Flow<List<Album>>

    @Query("select * from ${Constants.TableNames.ALBUM} where ${Constants.ColumnNames.ID} == :id")
    abstract fun get(id: Int): Flow<Album>

    @Query("select * from ${Constants.TableNames.ALBUM} where ${Constants.ColumnNames.ID} == :id")
    abstract fun getSingle(id: Int): Album?

    @Query("select * from ${Constants.TableNames.ALBUM}")
    abstract fun getAllWithPhotos(): Flow<List<AlbumWithPhotos>>

    @Query("select * from ${Constants.TableNames.ALBUM} where ${Constants.ColumnNames.USER_ID} == :userId")
    abstract fun getAllWithPhotos(userId: Int): Flow<List<AlbumWithPhotos>>

    @Query("select * from ${Constants.TableNames.ALBUM} where ${Constants.ColumnNames.ID} == :id")
    abstract fun getWithPhotos(id: Int): Flow<AlbumWithPhotos>
}
