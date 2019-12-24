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

package net.fonix232.typiapp.persistence.common

import androidx.room.*

abstract class BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(data: T): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(vararg data: T): List<Long>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(data: List<T>): List<Long>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(data: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(vararg data: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(data: List<T>)

    @Delete
    abstract fun delete(vararg data: T)

    @Transaction
    open fun upsert(vararg data: T) {
        val insertResult = insert(*data)
        update(data.filterIndexed { index, _ -> insertResult[index] == -1L })
    }

    @Transaction
    open fun upsert(data: List<T>) {
        val insertResult = insert(data)
        update(data.filterIndexed { index, _ -> insertResult[index] == -1L })
    }
}
