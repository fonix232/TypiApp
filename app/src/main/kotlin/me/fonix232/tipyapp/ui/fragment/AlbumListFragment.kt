package me.fonix232.tipyapp.ui.fragment

import android.os.Bundle
import android.view.View
import me.fonix232.common.ui.fragment.BaseFragment
import me.fonix232.tipyapp.R
import me.fonix232.tipyapp.bindings.AlbumListFragmentBinding
import me.fonix232.tipyapp.viewmodel.AlbumListViewModel

class AlbumListFragment: BaseFragment<AlbumListViewModel, AlbumListFragmentBinding>(AlbumListViewModel::class, R.layout.fragment_album_list) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userId = -1

        viewModel.init(userId)
    }
}