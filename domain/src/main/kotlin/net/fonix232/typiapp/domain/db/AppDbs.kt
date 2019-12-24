package net.fonix232.typiapp.domain.db

import net.fonix232.typiapp.domain.model.*

interface UserDatabase: IDatabase<User>
interface AlbumDatabase: IDatabaseWithSupertypeAndChildren<Album, User>
interface PhotoDatabase: IDatabaseWithSupertype<Photo, Album>
interface PostDatabase: IDatabaseWithSupertypeAndChildren<Post, User>
interface CommentDatabase: IDatabaseWithSupertype<Comment, Post>
interface TodoDatabase: IDatabaseWithSupertype<Todo, User>
