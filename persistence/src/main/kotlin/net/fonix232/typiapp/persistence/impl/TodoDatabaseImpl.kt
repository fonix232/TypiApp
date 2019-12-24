package net.fonix232.typiapp.persistence.impl

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import net.fonix232.typiapp.domain.db.TodoDatabase
import net.fonix232.typiapp.domain.model.Todo
import net.fonix232.typiapp.domain.model.User
import net.fonix232.typiapp.persistence.db.TypiDatabase
import net.fonix232.typiapp.persistence.toDb
import net.fonix232.typiapp.persistence.toDomain
import org.koin.core.KoinComponent
import org.koin.core.inject

@ExperimentalCoroutinesApi
internal class TodoDatabaseImpl : TodoDatabase, KoinComponent {

    //region Dependency Injection
    private val db: TypiDatabase by inject()
    //endregion

    override fun getAll(parent: User): Flow<List<Todo>> =
        db.todos.getAll(parent.id).distinctUntilChanged().map { it.map { it.toDomain() } }

    override fun getAll(): Flow<List<Todo>> =
        db.todos.getAll().distinctUntilChanged().map { it.map { it.toDomain() } }

    override fun get(id: Int): Flow<Todo> =
        db.todos.get(id).distinctUntilChanged().map { it.toDomain() }

    override fun delete(id: Int) {
        db.todos.getSingle(id)?.let { db.todos.delete(it) }
    }

    override fun upsert(vararg data: Todo) {
        db.todos.upsert(data.map { it.toDb() })
    }

    override fun upsert(data: List<Todo>) {
        db.todos.upsert(data.map { it.toDb() })
    }
}
