package net.fonix232.typiapp.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import net.fonix232.typiapp.R
import net.fonix232.typiapp.base.ui.adapter.BaseAdapter
import net.fonix232.typiapp.base.ui.fragment.BaseFragment
import net.fonix232.typiapp.databinding.FragmentUserListBinding
import net.fonix232.typiapp.domain.model.User
import net.fonix232.typiapp.domain.navigation.NavCommand
import net.fonix232.typiapp.viewmodel.UserListViewModel

class UserListFragment :
    BaseFragment<UserListViewModel, FragmentUserListBinding>(R.layout.fragment_user_list, UserListViewModel::class) {

    companion object {
        private const val TAG = "UserListFragment"
    }

    private val adapter: BaseAdapter<User> = BaseAdapter(R.layout.item_user) { viewModel.userSelected(it) }
    private val refreshListener = SwipeRefreshLayout.OnRefreshListener {
        binding.swipeContainer.isRefreshing = true
        viewModel.refresh { binding.swipeContainer.isRefreshing = false }
    }
    private val observer = Observer<List<User>> { adapter.items = it }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "View attached")
        viewModel.users.observe(this, observer)
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "View detached")
        viewModel.users.removeObserver(observer)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "View created")
        binding.userList.adapter = adapter
        adapter.items = viewModel.users.value ?: listOf()
        binding.swipeContainer.setOnRefreshListener(refreshListener)
        binding.swipeContainer.setProgressViewEndTarget(true, (128 * resources.displayMetrics.density).toInt())
    }

    override fun onNavigationCommand(command: NavCommand) {
        when (command) {
            is NavCommand.UserHome -> findNavController().navigate(
                command.commandId,
                UserHomeFragmentArgs(command.userId).toBundle()
            )
            else -> super.onNavigationCommand(command)
        }
    }
}
