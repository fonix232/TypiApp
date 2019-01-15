package me.fonix232.tipyapp.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import me.fonix232.common.ui.adapter.BaseAdapter
import me.fonix232.common.ui.adapter.BaseViewHolder
import me.fonix232.tipyapp.R
import me.fonix232.tipyapp.bindings.TodoItemBinding
import me.fonix232.tipyapp.model.Post

class PostAdapter(items: LiveData<List<Post>>, owner: LifecycleOwner, onClick: (View, Post) -> Unit) :
    BaseAdapter<Post, TodoItemBinding, BaseViewHolder<Post, TodoItemBinding>>(
        items,
        owner,
        R.layout.item_todo,
        onClick
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        object : BaseViewHolder<Post, TodoItemBinding>(inflate(parent), onClick) {}
}