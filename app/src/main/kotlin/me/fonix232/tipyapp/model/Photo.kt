package me.fonix232.tipyapp.model

import androidx.room.*
import com.squareup.moshi.Json

@Entity(
    tableName = "photos",
    foreignKeys = [ForeignKey(entity = Album::class, parentColumns = ["id"], childColumns = ["album_id"])],
    indices = [Index("album_id")]
)
data class Photo(
    @Json(name = "id") @PrimaryKey val id: Int,
    @Json(name = "title") val title: String,
    @Json(name = "url") val url: String,
    @Json(name = "thumbnailUrl") val thumbnailUrl: String,
    @Json(name = "albumId") @ColumnInfo(name = "album_id") val albumId: Int
)