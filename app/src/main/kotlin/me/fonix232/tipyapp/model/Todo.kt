package me.fonix232.tipyapp.model

import androidx.room.*
import com.squareup.moshi.Json

@Entity(
    tableName = "todos",
    foreignKeys = [ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["user_id"])],
    indices = [Index("user_id")]
)
data class Todo(
    @Json(name = "id") @PrimaryKey val id: Int,
    @Json(name = "title") val title: String,
    @Json(name = "completed") val completed: Boolean,
    @Json(name = "userId") @ColumnInfo(name = "user_id") val userId: Int
)