package net.fonix232.typiapp.persistence.impl

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import net.fonix232.typiapp.domain.db.AlbumDatabase
import net.fonix232.typiapp.domain.model.Album
import net.fonix232.typiapp.domain.model.User
import net.fonix232.typiapp.persistence.db.TypiDatabase
import net.fonix232.typiapp.persistence.toDb
import net.fonix232.typiapp.persistence.toDomain
import org.koin.core.KoinComponent
import org.koin.core.inject

@ExperimentalCoroutinesApi
internal class AlbumDatabaseImpl : AlbumDatabase, KoinComponent {

    //region Dependency Injection
    private val db: TypiDatabase by inject()
    //endregion

    override fun getAll(parent: User): Flow<List<Album>> =
        db.albums.getAll(parent.id).distinctUntilChanged().map { it.map { it.toDomain() } }

    override fun getAll(): Flow<List<Album>> =
        db.albums.getAll().distinctUntilChanged().map { it.map { it.toDomain() } }

    override fun get(id: Int): Flow<Album> =
        db.albums.get(id).distinctUntilChanged().map { it.toDomain() }


    override fun getAllWithChildren(parent: User): Flow<List<Album>> =
        db.albums.getAllWithPhotos(parent.id).distinctUntilChanged().map { it.map { it.toDomain() } }

    override fun getAllWithChildren(): Flow<List<Album>> =
        db.albums.getAllWithPhotos().distinctUntilChanged().map { it.map { it.toDomain() } }

    override fun getWithChildren(id: Int): Flow<Album> =
        db.albums.getWithPhotos(id).distinctUntilChanged().map { it.toDomain() }


    override fun delete(id: Int) {
        db.albums.getSingle(id)?.let { db.albums.delete(it) }
    }

    override fun upsert(vararg data: Album) {
        db.albums.upsert(data.map { it.toDb() })
    }

    override fun upsert(data: List<Album>) {
        db.albums.upsert(data.map { it.toDb() })
    }
}
