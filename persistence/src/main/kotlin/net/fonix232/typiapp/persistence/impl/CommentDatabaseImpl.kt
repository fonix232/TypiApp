package net.fonix232.typiapp.persistence.impl

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import net.fonix232.typiapp.domain.db.CommentDatabase
import net.fonix232.typiapp.domain.model.Comment
import net.fonix232.typiapp.domain.model.Post
import net.fonix232.typiapp.persistence.db.TypiDatabase
import net.fonix232.typiapp.persistence.toDb
import net.fonix232.typiapp.persistence.toDomain
import org.koin.core.KoinComponent
import org.koin.core.inject

@ExperimentalCoroutinesApi
internal class CommentDatabaseImpl : CommentDatabase, KoinComponent {

    //region Dependency Injection
    private val db: TypiDatabase by inject()
    //endregion

    override fun getAll(parent: Post): Flow<List<Comment>> =
        db.comments.getAll(parent.id).distinctUntilChanged().map { it.map { it.toDomain() } }

    override fun getAll(): Flow<List<Comment>> =
        db.comments.getAll().distinctUntilChanged().map { it.map { it.toDomain() } }

    override fun get(id: Int): Flow<Comment> =
        db.comments.get(id).distinctUntilChanged().map { it.toDomain() }

    override fun delete(id: Int) {
        db.comments.getSingle(id)?.let { db.comments.delete(it) }
    }

    override fun upsert(vararg data: Comment) {
        db.comments.upsert(data.map { it.toDb() })
    }

    override fun upsert(data: List<Comment>) {
        db.comments.upsert(data.map { it.toDb() })
    }
}
