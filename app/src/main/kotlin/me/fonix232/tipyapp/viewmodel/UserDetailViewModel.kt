package me.fonix232.tipyapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.navigation.NavController
import me.fonix232.common.viewmodel.BaseViewModel
import me.fonix232.tipyapp.common.Outcome
import me.fonix232.tipyapp.model.User
import me.fonix232.tipyapp.repository.UserRepository
import org.koin.standalone.inject

class UserDetailViewModel : BaseViewModel() {
    private val repo: UserRepository by inject()
    private var userId: Int = -1

    val isUpdating: LiveData<Boolean> = MediatorLiveData()
    val title: LiveData<String> = MediatorLiveData()
    val user: LiveData<User> = MediatorLiveData()

    init {
        (user as MediatorLiveData).addSource(repo.user) { outcome ->
            when(outcome) {
                is Outcome.Success -> user.postValue(outcome.data)
            }
        }
        (title as MediatorLiveData).addSource(repo.user) { outcome ->
            when(outcome) {
                is Outcome.Success -> title.postValue(outcome.data.name)
                is Outcome.Failure -> title.postValue("Failed to get user $userId")
                is Outcome.Progress -> title.postValue(if(outcome.loading) "Loading..." else "User $userId loaded")
            }
        }
        (isUpdating as MediatorLiveData).addSource(repo.user) { outcome ->
            when(outcome) {
                is Outcome.Progress -> isUpdating.postValue(outcome.loading)
            }
        }
    }

    fun init(userId: Int) {
        this.userId = userId
        update()
    }

    fun update() {
        repo.fetchSingle(userId)
    }
}