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
import androidx.room.Embedded
import androidx.room.Entity
import net.fonix232.typiapp.persistence.Constants

@Entity(
    tableName = Constants.TableNames.USER,
    primaryKeys = [Constants.ColumnNames.ID]
)
internal data class User(
    @ColumnInfo(name = Constants.ColumnNames.ID) val id: Int,
    @ColumnInfo(name = Constants.ColumnNames.NAME) val name: String,
    @ColumnInfo(name = Constants.ColumnNames.USERNAME) val username: String,
    @ColumnInfo(name = Constants.ColumnNames.EMAIL) val email: String,
    @Embedded(prefix = Constants.Prefixes.ADDRESS) val address: Address,
    @ColumnInfo(name = Constants.ColumnNames.PHONE) val phone: String,
    @ColumnInfo(name = Constants.ColumnNames.WEBSITE) val website: String,
    @Embedded(prefix = Constants.Prefixes.COMPANY) val company: Company
) {

    data class Address(
        val street: String,
        val suite: String,
        val city: String,
        val zipcode: String,
        val latitude: String,
        val longitude: String
    )

    data class Company(
        val name: String,
        val catchPhrase: String,
        val bullshit: String
    )
}
