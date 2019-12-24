/*
 * This file is part of TypiApp (https://github.com/fonix232/TypiApp/)
 * Copyright (c) 2019 Jozsef Kiraly <fonix232@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package net.fonix232.typiapp.network.api

import net.fonix232.typiapp.network.model.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface TypiApi {
    @GET("/users")
    suspend fun getUsers(): Response<List<User>>

    @GET("/users/{userId}")
    suspend fun getUser(@Path("userId") id: Int): Response<User>

    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("/posts")
    suspend fun getPosts(@Query("userId") userId: Int): Response<List<Post>>

    @GET("/posts/{postId}")
    suspend fun getPost(@Path("postId") id: Int): Response<Post>

    @GET("/comments")
    suspend fun getComments(): Response<List<Comment>>

    @GET("/comments")
    suspend fun getComments(@Query("postId") postId: Int): Response<List<Comment>>

    @GET("/comments/{commentId}")
    suspend fun getComment(@Path("commentId") id: Int): Response<Comment>

    @GET("/albums")
    suspend fun getAlbums(): Response<List<Album>>

    @GET("/albums")
    suspend fun getAlbums(@Query("userId") userId: Int): Response<List<Album>>

    @GET("/albums/{albumId}")
    suspend fun getAlbum(@Path("albumId") id: Int): Response<Album>

    @GET("/photos")
    suspend fun getPhotos(): Response<List<Photo>>

    @GET("/photos")
    suspend fun getPhotos(@Query("albumId") albumId: Int): Response<List<Photo>>

    @GET("/photos/{photoId}")
    suspend fun getPhoto(@Path("photoId") id: Int): Response<Photo>

    @GET("/todos")
    suspend fun getTodos(): Response<List<Todo>>

    @GET("/todos")
    suspend fun getTodos(@Query("userId") userId: Int): Response<List<Todo>>

    @GET("/todos/{todoId}")
    suspend fun getTodo(@Path("todoId") id: Int): Response<Todo>
}
