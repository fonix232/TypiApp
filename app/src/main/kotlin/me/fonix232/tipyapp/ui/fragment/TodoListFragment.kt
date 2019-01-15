package me.fonix232.tipyapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import me.fonix232.common.ui.fragment.BaseFragment
import me.fonix232.tipyapp.R
import me.fonix232.tipyapp.bindings.TodoListFragmentBinding
import me.fonix232.tipyapp.ui.adapter.TodoAdapter
import me.fonix232.tipyapp.viewmodel.TodoListViewModel

class TodoListFragment: BaseFragment<TodoListViewModel, TodoListFragmentBinding>(TodoListViewModel::class, R.layout.fragment_todo_list) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerview.adapter = TodoAdapter(viewModel.todos, this) { _, todo -> }
        binding.recyclerview.layoutManager = LinearLayoutManager(context)

        viewModel.init(TodoListFragmentArgs.fromBundle(arguments!!).userId)
    }
}