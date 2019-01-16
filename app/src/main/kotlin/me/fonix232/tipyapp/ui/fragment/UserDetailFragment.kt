package me.fonix232.tipyapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import me.fonix232.common.ui.fragment.BaseFragment
import me.fonix232.tipyapp.R
import me.fonix232.tipyapp.bindings.UserDetailFragmentBinding
import me.fonix232.tipyapp.ui.adapter.UserDetailAdapter
import me.fonix232.tipyapp.viewmodel.UserDetailViewModel

class UserDetailFragment : BaseFragment<UserDetailViewModel, UserDetailFragmentBinding>(
    UserDetailViewModel::class,
    R.layout.fragment_user_detail
) {

    val items: LiveData<List<String>> = MutableLiveData()

    companion object {
        const val ALBUMS = "Albums"
        const val POSTS = "Posts"
        const val TODOS = "Todos"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userId = UserDetailFragmentArgs.fromBundle(arguments!!).userId
        viewModel.init(userId)

        binding.recyclerview.adapter = UserDetailAdapter(items, this) { _, item ->
            when (item) {
                ALBUMS -> findNavController().navigate(
                    UserDetailFragmentDirections.actionUserDetailFragmentToAlbumListFragment(userId)
                )
                POSTS -> findNavController().navigate(
                    UserDetailFragmentDirections.actionUserDetailFragmentToPostListFragment(userId)
                )
                TODOS -> findNavController().navigate(
                    UserDetailFragmentDirections.actionUserDetailFragmentToTodoListFragment(userId)
                )
            }
        }
        binding.recyclerview.layoutManager = LinearLayoutManager(context)

        (items as MutableLiveData).postValue(listOf(ALBUMS, POSTS, TODOS))
    }
}