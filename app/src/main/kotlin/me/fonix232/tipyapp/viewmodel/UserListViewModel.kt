package me.fonix232.tipyapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import me.fonix232.common.viewmodel.BaseViewModel
import me.fonix232.tipyapp.common.Outcome
import me.fonix232.tipyapp.model.User
import me.fonix232.tipyapp.repository.UserRepository
import me.fonix232.tipyapp.toLiveData
import org.koin.standalone.inject
import timber.log.Timber

class UserListViewModel: BaseViewModel() {
    private val repo: UserRepository by inject()

    val isUpdating: LiveData<Boolean> = MediatorLiveData()
    val title: LiveData<String> = MediatorLiveData()
    val users: LiveData<List<User>> = MediatorLiveData()

    init {
        (isUpdating as MediatorLiveData).addSource(repo.users) { outcome ->
            when(outcome) {
                is Outcome.Progress -> {
                    Timber.d("Update ${outcome.loading}")
                    isUpdating.postValue(outcome.loading)
                }
            }
        }
        (title as MediatorLiveData).addSource(repo.users) { outcome ->
            when(outcome) {
                is Outcome.Success -> title.postValue("Users: ${outcome.data.size}")
                is Outcome.Failure -> title.postValue("Network failure")
                is Outcome.Progress -> if(outcome.loading) title.postValue("Loading...")
            }
        }
        (users as MediatorLiveData).addSource(repo.users) { outcome ->
            when(outcome) {
                is Outcome.Success -> users.postValue(outcome.data)
                is Outcome.Failure, is Outcome.Progress -> users.postValue(null)
            }
        }
    }

    fun update() {
        repo.fetchAll()
    }
}