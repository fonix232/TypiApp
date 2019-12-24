package net.fonix232.typiapp.repository

import net.fonix232.typiapp.base.repository.BaseRepositoryWithSupertype
import net.fonix232.typiapp.domain.client.CommentClient
import net.fonix232.typiapp.domain.db.CommentDatabase
import net.fonix232.typiapp.domain.model.Comment
import net.fonix232.typiapp.domain.model.Post
import net.fonix232.typiapp.domain.repository.CommentRepository
import org.koin.core.inject

class CommentRepositoryImpl(override val client: CommentClient, override val database: CommentDatabase):
    BaseRepositoryWithSupertype<Comment, Post>(), CommentRepository
