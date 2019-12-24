package net.fonix232.typiapp.domain.repository

import net.fonix232.typiapp.domain.model.*

interface UserRepository: Repository<User>
interface AlbumRepository: RepositoryWithSupertype<Album, User>
interface PhotoRepository: RepositoryWithSupertype<Photo, Album>
interface PostRepository: RepositoryWithSupertype<Post, User>
interface CommentRepository: RepositoryWithSupertype<Comment, Post>
interface TodoRepository: RepositoryWithSupertype<Todo, User>
