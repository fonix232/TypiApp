package net.fonix232.typiapp.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.fonix232.typiapp.base.viewmodel.BaseViewModel
import net.fonix232.typiapp.domain.navigation.NavCommand
import net.fonix232.typiapp.domain.repository.*
import org.koin.core.inject

class SplashViewModel: BaseViewModel() {

    //region Dependency Injection
    private val userRepo: UserRepository by inject()
    private val postRepo: PostRepository by inject()
    private val albumRepo: AlbumRepository by inject()
    private val todoRepo: TodoRepository by inject()
    private val photoRepo: PhotoRepository by inject()
    private val commentRepo: CommentRepository by inject()
    //endregion

    fun init() {
        viewModelScope.launch {
            listOf(
                async { userRepo.sync() },
                async { postRepo.sync() },
                async { albumRepo.sync() },
                async { todoRepo.sync() },
                async { photoRepo.sync() },
                async { commentRepo.sync() }
            ).awaitAll()
            postNavCommand(NavCommand.UserList)
        }
    }
}
