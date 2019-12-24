package net.fonix232.typiapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import net.fonix232.typiapp.base.viewmodel.BaseViewModel
import net.fonix232.typiapp.domain.model.User
import net.fonix232.typiapp.domain.repository.UserRepository
import org.koin.core.inject

class UserProfileViewModel: BaseViewModel() {

    //region Dependency Injection
    private val userRepo: UserRepository by inject()
    //endregion

    private val userId: LiveData<Int?> = MutableLiveData(null)

    val user: LiveData<User?> = userId.map { it?.let { userRepo.get(it) }  }

    fun init(userId: Int) {
        (this.userId as MutableLiveData).postValue(userId)
    }
}
