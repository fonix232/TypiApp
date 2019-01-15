package me.fonix232.tipyapp

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.room.Room
import com.squareup.moshi.Moshi
import io.reactivex.disposables.CompositeDisposable
import me.fonix232.tipyapp.api.IClient
import me.fonix232.tipyapp.api.typicode.ApiClient
import me.fonix232.tipyapp.db.TipyDb
import me.fonix232.tipyapp.repository.*
import me.fonix232.tipyapp.util.Synk
import me.fonix232.tipyapp.viewmodel.*
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module
import org.koin.experimental.builder.factory
import org.koin.experimental.builder.single
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object Keys {
    const val BASE_URL = "baseUrl"
}

val appModule = module {
    single<AlbumRepository>()
    single<CommentRepository>()
    single<PhotoRepository>()
    single<PostRepository>()
    single<TodoRepository>()
    single<UserRepository>()

    viewModel<MainViewModel>()
    viewModel<UserListViewModel>()
    viewModel<UserDetailViewModel>()
    viewModel<PostListViewModel>()
    viewModel<PostViewModel>()
    viewModel<AlbumListViewModel>()
    viewModel<AlbumViewModel>()
    viewModel<TodoListViewModel>()

    single<SharedPreferences> { PreferenceManager.getDefaultSharedPreferences(get<Context>()) }
    single<Synk>()
}

val dbModule = module {
    single<TipyDb> {
        Room.databaseBuilder(get<Context>(), TipyDb::class.java, TipyDb.DATABASE_NAME)
            .addMigrations(*TipyDb.MIGRATIONS.toTypedArray())
            .fallbackToDestructiveMigration()
            .build()
    }
}

val networkModule = module {
    single<Moshi> { Moshi.Builder().build() }
    single<Converter.Factory> { MoshiConverterFactory.create(get<Moshi>()) }
    single<CallAdapter.Factory> { RxJava2CallAdapterFactory.create() }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(get<String>(Keys.BASE_URL))
            .addConverterFactory(get<Converter.Factory>())
            .addCallAdapterFactory(get<CallAdapter.Factory>())
            .build()
    }

    factory< CompositeDisposable>()
}

val clientModule = module {
    single(Keys.BASE_URL) { "https://jsonplaceholder.typicode.com" }
    single<IClient> { ApiClient() }
}