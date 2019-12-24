package net.fonix232.typiapp.domain.client

import net.fonix232.typiapp.domain.model.*

interface UserClient: IClient<User>
interface AlbumClient: IClientWithSupertype<Album, User>
interface PhotoClient: IClientWithSupertype<Photo, Album>
interface PostClient: IClientWithSupertype<Post, User>
interface CommentClient: IClientWithSupertype<Comment, Post>
interface TodoClient: IClientWithSupertype<Todo, User>
