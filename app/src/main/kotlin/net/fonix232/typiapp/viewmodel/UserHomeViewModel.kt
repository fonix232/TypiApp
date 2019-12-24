package net.fonix232.typiapp.viewmodel

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import net.fonix232.typiapp.base.viewmodel.BaseViewModel
import net.fonix232.typiapp.domain.model.User
import net.fonix232.typiapp.domain.repository.UserRepository
import org.koin.core.inject

class UserHomeViewModel : BaseViewModel() {

    companion object {
        const val TAG = "UserHomeViewModel"
    }

    //region Dependency Injection
    private val userRepo: UserRepository by inject()
    //endregion

    private val userId: LiveData<Int?> = MutableLiveData(null)

    val user: LiveData<User?> = userId.map { it?.let { userRepo.get(it) } }

    val userName: LiveData<String?> = user.map { it?.name }

    init {
        Handler(Looper.getMainLooper()).post {
            userId.observeForever { Log.d(TAG, "UserId changed to $it") }
            user.observeForever { Log.d(TAG, "User changed to $it") }
            userName.observeForever { Log.d(TAG, "User name changed to $it") }
        }
    }

    fun init(userId: Int) {
        (this.userId as MutableLiveData).postValue(userId)
    }
}
