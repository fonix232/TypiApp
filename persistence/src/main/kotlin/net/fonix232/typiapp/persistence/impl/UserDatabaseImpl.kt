package net.fonix232.typiapp.persistence.impl

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import net.fonix232.typiapp.domain.db.UserDatabase
import net.fonix232.typiapp.domain.model.User
import net.fonix232.typiapp.persistence.db.TypiDatabase
import net.fonix232.typiapp.persistence.toDb
import net.fonix232.typiapp.persistence.toDomain
import org.koin.core.KoinComponent
import org.koin.core.inject

@ExperimentalCoroutinesApi
internal class UserDatabaseImpl : UserDatabase, KoinComponent {

    //region Dependency Injection
    private val db: TypiDatabase by inject()
    //endregion

    override fun getAll(): Flow<List<User>> =
        db.users.getAll().distinctUntilChanged().map { it.map { it.toDomain() } }

    override fun get(id: Int): Flow<User> =
        db.users.get(id).distinctUntilChanged().map { it.toDomain() }

    override fun delete(id: Int) {
        db.users.getSingle(id)?.let { db.users.delete(it) }
    }

    override fun upsert(vararg data: User) {
        db.users.upsert(data.map { it.toDb() })
    }

    override fun upsert(data: List<User>) {
        db.users.upsert(data.map { it.toDb() })
    }
}
