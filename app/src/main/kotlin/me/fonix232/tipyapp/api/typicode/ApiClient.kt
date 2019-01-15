package me.fonix232.tipyapp.api.typicode

import io.reactivex.Single
import me.fonix232.tipyapp.api.IClient
import me.fonix232.tipyapp.model.*
import me.fonix232.tipyapp.retrofit
import org.koin.standalone.KoinComponent
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class ApiClient : IClient, KoinComponent {

    private val api: TypiApi by retrofit()

    override fun getUsers() = api.getUsers()
    override fun getUser(id: Int) = api.getUser(id)

    override fun getPosts(userId: Int) = api.getPosts(userId)
    override fun getPost(id: Int) = api.getPost(id)
    override fun getComments(postId: Int) = api.getComments(postId)
    override fun getComment(id: Int) = api.getComment(id)

    override fun getAlbums(userId: Int) = api.getAlbums(userId)
    override fun getAlbum(id: Int) = api.getAlbum(id)
    override fun getPhotos(albumId: Int) = api.getPhotos(albumId)
    override fun getPhoto(id: Int) = api.getPhoto(id)

    override fun getTodos(userId: Int) = api.getTodos(userId)
    override fun getTodo(id: Int) = api.getTodo(id)

    private interface TypiApi {

        @GET("/users")
        fun getUsers(): Single<Response<List<User>>>

        @GET("/users/{id}")
        fun getUser(@Path("id") id: Int): Single<Response<User>>

        @GET("/posts")
        fun getPosts(@Query("userId") userId: Int): Single<Response<List<Post>>>

        @GET("/posts/{id}")
        fun getPost(@Path("id") id: Int): Single<Response<Post>>

        @GET("/comments")
        fun getComments(@Query("postId") postId: Int): Single<Response<List<Comment>>>

        @GET("/comments/{id}")
        fun getComment(@Path("id") id: Int): Single<Response<Comment>>

        @GET("/albums")
        fun getAlbums(@Query("userId") userId: Int): Single<Response<List<Album>>>

        @GET("/albums/{id}")
        fun getAlbum(@Path("id") id: Int): Single<Response<Album>>

        @GET("/photos")
        fun getPhotos(@Query("albumId") albumId: Int): Single<Response<List<Photo>>>

        @GET("/photos/{id}")
        fun getPhoto(@Path("id") id: Int): Single<Response<Photo>>

        @GET("/todos")
        fun getTodos(@Query("userId") userId: Int): Single<Response<List<Todo>>>

        @GET("/todos/{id}")
        fun getTodo(@Path("id") id: Int): Single<Response<Todo>>
    }
}