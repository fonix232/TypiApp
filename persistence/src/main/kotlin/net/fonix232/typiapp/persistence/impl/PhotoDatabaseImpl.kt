package net.fonix232.typiapp.persistence.impl

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import net.fonix232.typiapp.domain.db.PhotoDatabase
import net.fonix232.typiapp.domain.model.Album
import net.fonix232.typiapp.domain.model.Photo
import net.fonix232.typiapp.persistence.db.TypiDatabase
import net.fonix232.typiapp.persistence.toDb
import net.fonix232.typiapp.persistence.toDomain
import org.koin.core.KoinComponent
import org.koin.core.inject

@ExperimentalCoroutinesApi
internal class PhotoDatabaseImpl : PhotoDatabase, KoinComponent {

    //region Dependency Injection
    private val db: TypiDatabase by inject()
    //endregion

    override fun getAll(parent: Album): Flow<List<Photo>> =
        db.photos.getAll(parent.id).distinctUntilChanged().map { it.map { it.toDomain() } }

    override fun getAll(): Flow<List<Photo>> =
        db.photos.getAll().distinctUntilChanged().map { it.map { it.toDomain() } }

    override fun get(id: Int): Flow<Photo> =
        db.photos.get(id).distinctUntilChanged().map { it.toDomain() }

    override fun delete(id: Int) {
        db.photos.getSingle(id)?.let { db.photos.delete(it) }
    }

    override fun upsert(vararg data: Photo) {
        db.photos.upsert(data.map { it.toDb() })
    }

    override fun upsert(data: List<Photo>) {
        db.photos.upsert(data.map { it.toDb() })
    }
}
