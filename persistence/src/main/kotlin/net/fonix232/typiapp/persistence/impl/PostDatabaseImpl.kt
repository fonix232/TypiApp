package net.fonix232.typiapp.persistence.impl

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import net.fonix232.typiapp.domain.db.PostDatabase
import net.fonix232.typiapp.domain.model.Post
import net.fonix232.typiapp.domain.model.User
import net.fonix232.typiapp.persistence.db.TypiDatabase
import net.fonix232.typiapp.persistence.toDb
import net.fonix232.typiapp.persistence.toDomain
import org.koin.core.KoinComponent
import org.koin.core.inject

@ExperimentalCoroutinesApi
internal class PostDatabaseImpl : PostDatabase, KoinComponent {

    //region Dependency Injection
    private val db: TypiDatabase by inject()
    //endregion

    override fun getAll(parent: User): Flow<List<Post>> =
        db.posts.getAll(parent.id).distinctUntilChanged().map { it.map { it.toDomain() } }

    override fun getAll(): Flow<List<Post>> =
        db.posts.getAll().distinctUntilChanged().map { it.map { it.toDomain() } }

    override fun get(id: Int): Flow<Post> =
        db.posts.get(id).distinctUntilChanged().map { it.toDomain() }


    override fun getAllWithChildren(parent: User): Flow<List<Post>> =
        db.posts.getAll(parent.id).distinctUntilChanged().map { it.map { it.toDomain() } }

    override fun getAllWithChildren(): Flow<List<Post>> =
        db.posts.getAll().distinctUntilChanged().map { it.map { it.toDomain() } }

    override fun getWithChildren(id: Int): Flow<Post> =
        db.posts.get(id).distinctUntilChanged().map { it.toDomain() }

    override fun delete(id: Int) {
        db.posts.getSingle(id)?.let { db.posts.delete(it) }
    }

    override fun upsert(vararg data: Post) {
        db.posts.upsert(data.map { it.toDb() })
    }

    override fun upsert(data: List<Post>) {
        db.posts.upsert(data.map { it.toDb() })
    }
}
