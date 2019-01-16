package me.fonix232.tipyapp.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import me.fonix232.common.ui.adapter.BaseAdapter
import me.fonix232.common.ui.adapter.BaseViewHolder
import me.fonix232.tipyapp.R
import me.fonix232.tipyapp.bindings.PhotoItemBinding
import me.fonix232.tipyapp.bindings.TodoItemBinding
import me.fonix232.tipyapp.model.Photo

class PhotoAdapter(items: LiveData<List<Photo>>, owner: LifecycleOwner, onClick: (View, Photo) -> Unit) :
    BaseAdapter<Photo, PhotoItemBinding, BaseViewHolder<Photo, PhotoItemBinding>>(
        items,
        owner,
        R.layout.item_photo,
        onClick
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        object : BaseViewHolder<Photo, PhotoItemBinding>(inflate(parent), onClick) {}
}