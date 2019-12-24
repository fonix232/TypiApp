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

package net.fonix232.typiapp.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class User(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "username") val username: String,
    @Json(name = "email") val email: String,
    @Json(name = "address") val address: Address,
    @Json(name = "phone") val phone: String,
    @Json(name = "website") val website: String,
    @Json(name = "company") val company: Company
) {

    @JsonClass(generateAdapter = true)
    data class Address(
        @Json(name = "street") val street: String,
        @Json(name = "suite") val suite: String,
        @Json(name = "city") val city: String,
        @Json(name = "zipcode") val zipcode: String,
        @Json(name = "geo") val location: Geolocation
    ) {

        @JsonClass(generateAdapter = true)
        data class Geolocation(
            @Json(name = "lat") val latitude: String,
            @Json(name = "lng") val longitude: String
        )
    }

    @JsonClass(generateAdapter = true)
    data class Company(
        @Json(name = "name") val name: String,
        @Json(name = "catchPhrase") val catchPhrase: String,
        @Json(name = "bs") val bullshit: String
    )
}
