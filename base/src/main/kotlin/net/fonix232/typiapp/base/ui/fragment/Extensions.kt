package net.fonix232.typiapp.base.ui.fragment

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import net.fonix232.typiapp.base.BR
import net.fonix232.typiapp.base.viewmodel.BaseViewModel

fun <B : ViewDataBinding> BaseFragment<*, B>.bind(): Lazy<B> = lazy {
    DataBindingUtil.bind<B>(view ?: throw Exception("View is null"))
        ?.setViewModel(viewModel) as B
}

fun ViewDataBinding.setViewModel(vm: BaseViewModel) = apply {
    setVariable(BR.viewModel, vm)
    executePendingBindings()
}
