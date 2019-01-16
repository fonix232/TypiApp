package me.fonix232.tipyapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import me.fonix232.common.viewmodel.BaseViewModel
import me.fonix232.tipyapp.common.Outcome
import me.fonix232.tipyapp.model.Comment
import me.fonix232.tipyapp.model.Post
import me.fonix232.tipyapp.repository.CommentRepository
import me.fonix232.tipyapp.repository.PostRepository
import org.koin.standalone.inject

class PostViewModel : BaseViewModel() {
    private val postRepo: PostRepository by inject()
    private val commentRepo: CommentRepository by inject()

    private var postId = -1

    val isUpdating: LiveData<Boolean> = MediatorLiveData()
    val title: LiveData<String> = MediatorLiveData()
    val post: LiveData<Post> = MediatorLiveData()
    val comments: LiveData<List<Comment>> = MediatorLiveData()

    init {
        (comments as MediatorLiveData).addSource(commentRepo.comments) { outcome ->
            when (outcome) {
                is Outcome.Success -> comments.postValue(outcome.data)
            }
        }
        (post as MediatorLiveData).addSource(postRepo.post) { outcome ->
            when(outcome) {
                is Outcome.Success -> post.postValue(outcome.data)
            }
        }
        (title as MediatorLiveData).addSource(commentRepo.comments) { outcome ->
            when (outcome) {
                is Outcome.Success -> title.postValue("Post $postId comments: ${outcome.data.size}")
                is Outcome.Failure -> title.postValue("Network failure")
                is Outcome.Progress -> if (outcome.loading) title.postValue("Loading...")
            }
        }
        (isUpdating as MediatorLiveData).addSource(commentRepo.comments) { outcome ->
            when (outcome) {
                is Outcome.Progress -> isUpdating.postValue(outcome.loading)
            }
        }
    }

    fun init(postId: Int) {
        this.postId = postId
        update()
    }

    fun update() {
        postRepo.fetchSingle(postId)
        commentRepo.fetchAll(postId)
    }
}