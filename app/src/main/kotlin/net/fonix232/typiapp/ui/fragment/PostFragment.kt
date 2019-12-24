package net.fonix232.typiapp.ui.fragment

import net.fonix232.typiapp.R
import net.fonix232.typiapp.base.ui.fragment.BaseFragment
import net.fonix232.typiapp.databinding.FragmentPostBinding
import net.fonix232.typiapp.viewmodel.PostViewModel

class PostFragment : BaseFragment<PostViewModel, FragmentPostBinding>(R.layout.fragment_post, PostViewModel::class) {
}
