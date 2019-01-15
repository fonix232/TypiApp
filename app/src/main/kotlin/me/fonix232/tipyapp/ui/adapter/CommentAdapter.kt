package me.fonix232.tipyapp.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import me.fonix232.common.ui.adapter.BaseAdapter
import me.fonix232.common.ui.adapter.BaseViewHolder
import me.fonix232.tipyapp.R
import me.fonix232.tipyapp.bindings.TodoItemBinding
import me.fonix232.tipyapp.model.Comment
import me.fonix232.tipyapp.model.Todo

class CommentAdapter(items: LiveData<List<Comment>>, owner: LifecycleOwner, onClick: (View, Comment) -> Unit) :
    BaseAdapter<Comment, TodoItemBinding, BaseViewHolder<Comment, TodoItemBinding>>(
        items,
        owner,
        R.layout.item_todo,
        onClick
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        object : BaseViewHolder<Comment, TodoItemBinding>(inflate(parent), onClick) {}
}