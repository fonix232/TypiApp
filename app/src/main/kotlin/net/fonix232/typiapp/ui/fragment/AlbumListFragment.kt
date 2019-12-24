package net.fonix232.typiapp.ui.fragment

import net.fonix232.typiapp.R
import net.fonix232.typiapp.base.ui.fragment.BaseFragment
import net.fonix232.typiapp.databinding.FragmentAlbumListBinding
import net.fonix232.typiapp.viewmodel.AlbumListViewModel

class AlbumListFragment : BaseFragment<AlbumListViewModel, FragmentAlbumListBinding>(
    R.layout.fragment_album_list,
    AlbumListViewModel::class
) {

}
