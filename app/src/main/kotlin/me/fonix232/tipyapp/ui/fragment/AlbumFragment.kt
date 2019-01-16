package me.fonix232.tipyapp.ui.fragment

import android.os.Bundle
import android.view.View
import me.fonix232.common.ui.fragment.BaseFragment
import me.fonix232.tipyapp.R
import me.fonix232.tipyapp.bindings.AlbumDetailFragmentBinding
import me.fonix232.tipyapp.viewmodel.AlbumViewModel

class AlbumFragment: BaseFragment<AlbumViewModel, AlbumDetailFragmentBinding>(AlbumViewModel::class, R.layout.fragment_album_detail) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val albumId = -1
        viewModel.init(albumId)
    }
}