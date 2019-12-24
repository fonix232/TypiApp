package net.fonix232.typiapp.domain.navigation

import androidx.annotation.IdRes
import net.fonix232.typiapp.domain.R

sealed class NavCommand(@IdRes val commandId: Int) {
    object Back: NavCommand(-1)
    object Splash: NavCommand(R.id.goToSplash)
    object UserList: NavCommand(R.id.splashToUserList)
    class UserHome(val userId: Int): NavCommand(R.id.userListToUserHome)
    class PostList(val userId: Int): NavCommand(R.id.userHomeToPostList)
    class AlbumList(val userId: Int): NavCommand(R.id.userHomeToAlbumList)
    class TodoList(val userId: Int): NavCommand(R.id.userHomeToTodoList)
    class UserProfile(val userId: Int): NavCommand(R.id.userHomeToUserProfile)
    class Post(val postId: Int): NavCommand(R.id.postListToPostDetail)
    class Album(val albumId: Int): NavCommand(R.id.albumListToAlbumDetail)
}
