package me.fonix232.tipyapp.model

import androidx.room.*
import com.squareup.moshi.Json

@Entity(
    tableName = "comments",
    foreignKeys = [ForeignKey(entity = Post::class, parentColumns = ["id"], childColumns = ["post_id"])],
    indices = [Index("post_id")]
)
data class Comment(
    @Json(name = "id") @PrimaryKey val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "email") val email: String,
    @Json(name = "body") val body: String,
    @Json(name = "postId") @ColumnInfo(name = "post_id") val postId: Int
)