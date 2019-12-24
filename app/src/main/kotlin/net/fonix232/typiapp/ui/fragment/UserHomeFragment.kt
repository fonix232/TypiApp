package net.fonix232.typiapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import net.fonix232.typiapp.R
import net.fonix232.typiapp.base.ui.fragment.BaseFragment
import net.fonix232.typiapp.databinding.FragmentUserHomeBinding
import net.fonix232.typiapp.viewmodel.UserHomeViewModel

class UserHomeFragment : BaseFragment<UserHomeViewModel, FragmentUserHomeBinding>(
    R.layout.fragment_user_home,
    UserHomeViewModel::class
) {

    private val args: UserHomeFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.init(args.userId)
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }

}
