package net.fonix232.typiapp.persistence.model

import androidx.room.Embedded
import androidx.room.Relation
import net.fonix232.typiapp.persistence.Constants

internal data class PostWithComments(
    @Embedded val post: Post,
    @Relation(
        parentColumn = Constants.ColumnNames.ID,
        entityColumn = Constants.ColumnNames.POST_ID
    ) val comments: List<Comment>
)
