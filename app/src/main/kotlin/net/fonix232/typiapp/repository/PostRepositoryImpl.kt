package net.fonix232.typiapp.repository

import net.fonix232.typiapp.base.repository.BaseRepositoryWithSupertypeAndChildren
import net.fonix232.typiapp.domain.client.PostClient
import net.fonix232.typiapp.domain.db.PostDatabase
import net.fonix232.typiapp.domain.model.Album
import net.fonix232.typiapp.domain.model.Post
import net.fonix232.typiapp.domain.model.User
import net.fonix232.typiapp.domain.repository.PostRepository
import org.koin.core.inject

class PostRepositoryImpl(override val client: PostClient, override val database: PostDatabase):
    BaseRepositoryWithSupertypeAndChildren<Post, User>(), PostRepository
