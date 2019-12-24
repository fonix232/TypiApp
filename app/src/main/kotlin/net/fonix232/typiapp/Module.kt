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

package net.fonix232.typiapp

import net.fonix232.typiapp.domain.repository.*
import net.fonix232.typiapp.repository.*
import net.fonix232.typiapp.ui.fragment.*
import net.fonix232.typiapp.viewmodel.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.android.experimental.dsl.viewModel
import org.koin.androidx.fragment.dsl.fragment

val repositoryModule = module {
    single<AlbumRepository> { AlbumRepositoryImpl(get(), get()) }
    single<CommentRepository> { CommentRepositoryImpl(get(), get()) }
    single<PhotoRepository> { PhotoRepositoryImpl(get(), get()) }
    single<PostRepository> { PostRepositoryImpl(get(), get()) }
    single<TodoRepository> { TodoRepositoryImpl(get(), get()) }
    single<UserRepository> { UserRepositoryImpl(get(), get()) }
}

val uiModule = module {
    viewModel<SplashViewModel>()
    viewModel<UserListViewModel>()
    viewModel<UserHomeViewModel>()
    viewModel<UserProfileViewModel>()
    viewModel<AlbumListViewModel>()
    viewModel<AlbumViewModel>()
    viewModel<PostListViewModel>()
    viewModel<PostViewModel>()
    viewModel<TodoListViewModel>()

    fragment { SplashFragment() }
    fragment { UserListFragment() }
    fragment { UserHomeFragment() }
    fragment { UserProfileFragment() }
    fragment { AlbumListFragment() }
    fragment { AlbumFragment() }
    fragment { PostListFragment() }
    fragment { PostFragment() }
    fragment { TodoListFragment() }
}

