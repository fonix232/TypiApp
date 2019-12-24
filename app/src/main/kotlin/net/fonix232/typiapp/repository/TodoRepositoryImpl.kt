package net.fonix232.typiapp.repository

import net.fonix232.typiapp.base.repository.BaseRepositoryWithSupertype
import net.fonix232.typiapp.domain.client.TodoClient
import net.fonix232.typiapp.domain.db.TodoDatabase
import net.fonix232.typiapp.domain.model.Album
import net.fonix232.typiapp.domain.model.Todo
import net.fonix232.typiapp.domain.model.User
import net.fonix232.typiapp.domain.repository.TodoRepository
import org.koin.core.inject

class TodoRepositoryImpl(override val client: TodoClient, override val database: TodoDatabase):
    BaseRepositoryWithSupertype<Todo, User>(), TodoRepository
