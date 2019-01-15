package me.fonix232.tipyapp.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import me.fonix232.tipyapp.api.StringToLong

@Entity(tableName = "users")
data class User(
    @Json(name = "id") @PrimaryKey val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "username") val username: String,
    @Json(name = "email") val email: String,
    @Json(name = "address") @Embedded(prefix = "address_") val address: Address,
    @Json(name = "phone") val phone: String,
    @Json(name = "website") val website: String,
    @Json(name = "company") @Embedded(prefix = "company_") val company: Company
) {

    data class Address(
        @Json(name = "street") val street: String,
        @Json(name = "suite") val suite: String,
        @Json(name = "city") val city: String,
        @Json(name = "zipcode") val zipcode: String,
        @Json(name = "geo") @Embedded val geo: Geolocation
    )

    data class Geolocation(
        @Json(name = "lat") @StringToLong val latitude: Long,
        @Json(name = "lng") @StringToLong val longitude: Long
    )

    data class Company(
        @Json(name = "name") val name: String,
        @Json(name = "catchPhrase") val catchPhrase: String,
        @Json(name = "bs") val bs: String
    )
}

