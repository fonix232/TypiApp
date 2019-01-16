package me.fonix232.tipyapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import me.fonix232.common.ui.fragment.BaseFragment
import me.fonix232.tipyapp.R
import me.fonix232.tipyapp.bindings.PostDetailFragmentBinding
import me.fonix232.tipyapp.ui.adapter.CommentAdapter
import me.fonix232.tipyapp.viewmodel.PostViewModel

class PostFragment :
    BaseFragment<PostViewModel, PostDetailFragmentBinding>(PostViewModel::class, R.layout.fragment_post_detail) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.init(PostFragmentArgs.fromBundle(arguments!!).postId)

        binding.recyclerview.adapter = CommentAdapter(viewModel.comments, this) { _, _ -> }
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
    }
}