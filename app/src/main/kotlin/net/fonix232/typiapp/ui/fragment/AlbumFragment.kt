package net.fonix232.typiapp.ui.fragment

import net.fonix232.typiapp.R
import net.fonix232.typiapp.base.ui.fragment.BaseFragment
import net.fonix232.typiapp.databinding.FragmentAlbumBinding
import net.fonix232.typiapp.viewmodel.AlbumViewModel

class AlbumFragment :
    BaseFragment<AlbumViewModel, FragmentAlbumBinding>(R.layout.fragment_album, AlbumViewModel::class) {
}
