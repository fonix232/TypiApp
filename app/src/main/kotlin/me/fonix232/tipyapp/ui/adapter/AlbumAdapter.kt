package me.fonix232.tipyapp.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import me.fonix232.common.ui.adapter.BaseAdapter
import me.fonix232.common.ui.adapter.BaseViewHolder
import me.fonix232.tipyapp.R
import me.fonix232.tipyapp.bindings.AlbumItemBinding
import me.fonix232.tipyapp.bindings.TodoItemBinding
import me.fonix232.tipyapp.model.Album

class AlbumAdapter(items: LiveData<List<Album>>, owner: LifecycleOwner, onClick: (View, Album) -> Unit) :
    BaseAdapter<Album, AlbumItemBinding, BaseViewHolder<Album, AlbumItemBinding>>(
        items,
        owner,
        R.layout.item_album,
        onClick
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        object : BaseViewHolder<Album, AlbumItemBinding>(inflate(parent), onClick) {}
}