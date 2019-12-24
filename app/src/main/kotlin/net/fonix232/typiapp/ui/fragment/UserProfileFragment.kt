package net.fonix232.typiapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import net.fonix232.typiapp.R
import net.fonix232.typiapp.base.ui.fragment.BaseFragment
import net.fonix232.typiapp.databinding.FragmentUserProfileBinding
import net.fonix232.typiapp.viewmodel.UserProfileViewModel

class UserProfileFragment : BaseFragment<UserProfileViewModel, FragmentUserProfileBinding>(
    R.layout.fragment_user_profile,
    UserProfileViewModel::class
) {

    val args: UserProfileFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.init(args.userId)
    }
}
