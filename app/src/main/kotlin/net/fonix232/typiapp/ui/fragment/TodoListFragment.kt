package net.fonix232.typiapp.ui.fragment

import net.fonix232.typiapp.R
import net.fonix232.typiapp.base.ui.fragment.BaseFragment
import net.fonix232.typiapp.databinding.FragmentTodoListBinding
import net.fonix232.typiapp.viewmodel.TodoListViewModel

class TodoListFragment :
    BaseFragment<TodoListViewModel, FragmentTodoListBinding>(R.layout.fragment_todo_list, TodoListViewModel::class) {
}
