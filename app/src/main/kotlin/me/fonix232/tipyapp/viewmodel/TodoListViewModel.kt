package me.fonix232.tipyapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import me.fonix232.common.viewmodel.BaseViewModel
import me.fonix232.tipyapp.common.Outcome
import me.fonix232.tipyapp.model.Todo
import me.fonix232.tipyapp.repository.TodoRepository
import org.koin.standalone.inject
import timber.log.Timber

class TodoListViewModel: BaseViewModel() {
    private val repo: TodoRepository by inject()

    private var userId: Int = -1

    val isUpdating: LiveData<Boolean> = MediatorLiveData()
    val title: LiveData<String> = MediatorLiveData()
    val todos: LiveData<List<Todo>> = MediatorLiveData()

    init {
        (todos as MediatorLiveData).addSource(repo.todos) {outcome ->
            when(outcome) {
                is Outcome.Success -> todos.postValue(outcome.data)
            }
        }
        (title as MediatorLiveData).addSource(repo.todos) { outcome ->
            when(outcome) {
                is Outcome.Success -> title.postValue("Todos: ${outcome.data.size}")
                is Outcome.Failure -> title.postValue("Network failure")
                is Outcome.Progress -> if(outcome.loading) title.postValue("Loading...")
            }
        }
        (isUpdating as MediatorLiveData).addSource(repo.todos) { outcome ->
            when(outcome) {
                is Outcome.Progress -> {
                    Timber.d("Update ${outcome.loading}")
                    isUpdating.postValue(outcome.loading)
                }
            }
        }
    }

    fun init(userId: Int) {
        this.userId = userId
        update()
    }

    fun update() {
        repo.fetchAll(userId)
    }
}