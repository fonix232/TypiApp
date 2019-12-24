package net.fonix232.typiapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.findNavController
import net.fonix232.typiapp.R
import net.fonix232.typiapp.base.ui.fragment.BaseFragment
import net.fonix232.typiapp.domain.navigation.NavCommand
import net.fonix232.typiapp.viewmodel.SplashViewModel

class SplashFragment :
    BaseFragment<SplashViewModel, ViewDataBinding>(R.layout.fragment_splash, SplashViewModel::class) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.init()
    }

    override fun onNavigationCommand(command: NavCommand) {
        when(command) {
            is NavCommand.UserList -> findNavController().navigate(command.commandId)
            else -> super.onNavigationCommand(command)
        }
    }
}
