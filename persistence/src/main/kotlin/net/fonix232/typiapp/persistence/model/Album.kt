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

package net.fonix232.typiapp.persistence.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import net.fonix232.typiapp.persistence.Constants

@Entity(
    tableName = Constants.TableNames.ALBUM,
    primaryKeys = [Constants.ColumnNames.ID]
)
internal data class Album(
    @ColumnInfo(name = Constants.ColumnNames.ID) val id: Int,
    @ColumnInfo(name = Constants.ColumnNames.USER_ID) val userId: Int,
    @ColumnInfo(name = Constants.ColumnNames.TITLE) val title: String
)
