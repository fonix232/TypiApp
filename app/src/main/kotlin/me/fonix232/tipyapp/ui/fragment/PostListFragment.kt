package me.fonix232.tipyapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import me.fonix232.common.ui.fragment.BaseFragment
import me.fonix232.tipyapp.R
import me.fonix232.tipyapp.bindings.PostListFragmentBinding
import me.fonix232.tipyapp.ui.adapter.PostAdapter
import me.fonix232.tipyapp.viewmodel.PostListViewModel

class PostListFragment: BaseFragment<PostListViewModel, PostListFragmentBinding>(PostListViewModel::class, R.layout.fragment_post_list) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.init(PostListFragmentArgs.fromBundle(arguments!!).userId)

        binding.recyclerview.adapter = PostAdapter(viewModel.posts, this) { _, post ->
            findNavController().navigate(PostListFragmentDirections.actionPostListFragmentToPostFragment(post.id))
        }
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
    }
}