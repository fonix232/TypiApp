package net.fonix232.typiapp.ui.fragment

import net.fonix232.typiapp.R
import net.fonix232.typiapp.base.ui.fragment.BaseFragment
import net.fonix232.typiapp.databinding.FragmentPostListBinding
import net.fonix232.typiapp.viewmodel.PostListViewModel

class PostListFragment :
    BaseFragment<PostListViewModel, FragmentPostListBinding>(R.layout.fragment_post_list, PostListViewModel::class) {

}
