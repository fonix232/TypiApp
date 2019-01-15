package me.fonix232.tipyapp.api

import io.reactivex.Single
import me.fonix232.tipyapp.model.*
import retrofit2.Response

interface IClient {
    fun getUsers(): Single<Response<List<User>>>
    fun getUser(id: Int): Single<Response<User>>

    fun getPosts(userId: Int): Single<Response<List<Post>>>
    fun getPost(id: Int): Single<Response<Post>>
    fun getComments(postId: Int): Single<Response<List<Comment>>>
    fun getComment(id: Int): Single<Response<Comment>>

    fun getAlbums(userId: Int): Single<Response<List<Album>>>
    fun getAlbum(id: Int): Single<Response<Album>>
    fun getPhotos(albumId: Int): Single<Response<List<Photo>>>
    fun getPhoto(id: Int): Single<Response<Photo>>

    fun getTodos(userId: Int): Single<Response<List<Todo>>>
    fun getTodo(id: Int): Single<Response<Todo>>
}