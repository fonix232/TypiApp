package me.fonix232.tipyapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import me.fonix232.common.ui.fragment.BaseFragment
import me.fonix232.tipyapp.R
import me.fonix232.tipyapp.bindings.UserListFragmentBinding
import me.fonix232.tipyapp.ui.adapter.UsersAdapter
import me.fonix232.tipyapp.viewmodel.UserListViewModel

class UserListFragment: BaseFragment<UserListViewModel, UserListFragmentBinding>(UserListViewModel::class, R.layout.fragment_user_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerview.adapter = UsersAdapter(viewModel.users, this) { _, user -> findNavController().navigate(UserListFragmentDirections.actionUserListFragmentToUserDetailFragment(user.id)) }
        binding.recyclerview.layoutManager = LinearLayoutManager(context)

        viewModel.init()
    }
}