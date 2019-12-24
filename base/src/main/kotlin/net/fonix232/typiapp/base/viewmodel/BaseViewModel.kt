package net.fonix232.typiapp.base.viewmodel

import androidx.lifecycle.ViewModel
import net.fonix232.typiapp.domain.navigation.NavCommand
import net.fonix232.typiapp.domain.util.SingleLiveEvent
import org.koin.core.KoinComponent

abstract class BaseViewModel: ViewModel(), KoinComponent {

    val navCommand: SingleLiveEvent<NavCommand> = SingleLiveEvent()

    fun postNavCommand(command: NavCommand) {
        navCommand.postValue(command)
    }

    open fun onAttach() {}
    open fun onDetach() {}
}
