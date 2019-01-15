package me.fonix232.tipyapp.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import me.fonix232.common.ui.adapter.BaseAdapter
import me.fonix232.common.ui.adapter.BaseViewHolder
import me.fonix232.tipyapp.R
import me.fonix232.tipyapp.bindings.TodoItemBinding
import me.fonix232.tipyapp.model.Todo

class TodoAdapter(items: LiveData<List<Todo>>, owner: LifecycleOwner, onClick: (View, Todo) -> Unit) :
    BaseAdapter<Todo, TodoItemBinding, BaseViewHolder<Todo, TodoItemBinding>>(
        items,
        owner,
        R.layout.item_todo,
        onClick
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        object : BaseViewHolder<Todo, TodoItemBinding>(inflate(parent), onClick) {}
}