package net.fonix232.typiapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import net.fonix232.typiapp.base.viewmodel.BaseViewModel
import net.fonix232.typiapp.domain.model.User
import net.fonix232.typiapp.domain.navigation.NavCommand
import net.fonix232.typiapp.domain.repository.UserRepository
import org.koin.core.inject

class UserListViewModel: BaseViewModel() {

    //region Dependency Injection
    private val userRepo: UserRepository by inject()
    //endregion

    val users: LiveData<List<User>> = userRepo.items

    fun userSelected(user: User?) {
        user?.let { postNavCommand(NavCommand.UserHome(it.id)) }
    }

    fun refresh(whenFinished: () -> Unit) {
        viewModelScope.async {
            withContext(Dispatchers.IO) { userRepo.sync() }
            withContext(Dispatchers.Main) { whenFinished() }
        }
    }
}
