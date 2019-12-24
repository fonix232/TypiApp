package net.fonix232.typiapp.persistence.model

import androidx.room.Embedded
import androidx.room.Relation
import net.fonix232.typiapp.persistence.Constants

internal data class AlbumWithPhotos(
    @Embedded val album: Album,
    @Relation(
        parentColumn = Constants.ColumnNames.ID,
        entityColumn = Constants.ColumnNames.ALBUM_ID
    ) val photos: List<Photo>
)
