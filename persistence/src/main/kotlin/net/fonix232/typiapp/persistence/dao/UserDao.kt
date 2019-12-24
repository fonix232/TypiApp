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
import net.fonix232.typiapp.persistence.Constants
import net.fonix232.typiapp.persistence.common.BaseDao
import net.fonix232.typiapp.persistence.model.User

@Dao
internal abstract class UserDao : BaseDao<User>() {
    @Query("select * from ${Constants.TableNames.USER}")
    abstract fun getAll(): Flow<List<User>>

    @Query("select * from ${Constants.TableNames.USER} where ${Constants.ColumnNames.ID} == :id")
    abstract fun get(id: Int): Flow<User>

    @Query("select * from ${Constants.TableNames.USER} where ${Constants.ColumnNames.ID} == :id")
    abstract fun getSingle(id: Int): User?
}
