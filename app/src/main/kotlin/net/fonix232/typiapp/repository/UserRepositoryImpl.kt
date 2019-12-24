package net.fonix232.typiapp.repository

import net.fonix232.typiapp.base.repository.BaseRepository
import net.fonix232.typiapp.domain.client.UserClient
import net.fonix232.typiapp.domain.db.UserDatabase
import net.fonix232.typiapp.domain.model.User
import net.fonix232.typiapp.domain.repository.UserRepository
import org.koin.core.inject

class UserRepositoryImpl(override val client: UserClient, override val database: UserDatabase):
    BaseRepository<User>(), UserRepository
