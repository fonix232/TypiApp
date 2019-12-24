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

package net.fonix232.typiapp.domain.model

data class User(
    override val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
) : BaseModel {

    val monogram: String = name.split(" ").joinToString("") { it.first().toUpperCase().toString() }

    data class Address(
        val street: String,
        val suite: String,
        val city: String,
        val zipcode: String,
        val location: Geolocation
    ) {
        data class Geolocation(
            val latitude: String,
            val longitude: String
        )
    }

    data class Company(
        val name: String,
        val catchPhrase: String,
        val bullshit: String
    )
}
