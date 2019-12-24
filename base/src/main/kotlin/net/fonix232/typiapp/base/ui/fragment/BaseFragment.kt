package net.fonix232.typiapp.base.ui.fragment

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import net.fonix232.typiapp.base.viewmodel.BaseViewModel
import net.fonix232.typiapp.domain.navigation.NavCommand
import net.fonix232.typiapp.domain.navigation.NavigationException
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

abstract class BaseFragment<VM : BaseViewModel, B : ViewDataBinding>(
    @LayoutRes layout: Int,
    vmClass: KClass<VM>
) : Fragment(layout) {

    //region Dependency Injection
    val viewModel: VM by viewModel(vmClass)
    //endregion

    //region Databinding
    open val binding: B by bind()
    //endregion

    //region Navigation and lifecycle
    private val navObserver: Observer<NavCommand> = Observer { onNavigationCommand(it) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.navCommand.observe(this, navObserver)
        viewModel.onAttach()
    }

    override fun onDetach() {
        super.onDetach()
        viewModel.onDetach()
        viewModel.navCommand.removeObserver(navObserver)
    }

    open fun onNavigationCommand(command: NavCommand) {
        when (command) {
            is NavCommand.Back -> findNavController().navigateUp()
            else -> throw NavigationException(command)
        }
    }
    //endregion
}
