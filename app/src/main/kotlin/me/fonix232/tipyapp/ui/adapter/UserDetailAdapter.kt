package me.fonix232.tipyapp.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import me.fonix232.common.ui.adapter.BaseAdapter
import me.fonix232.common.ui.adapter.BaseViewHolder
import me.fonix232.tipyapp.R
import me.fonix232.tipyapp.bindings.UserDetailItemBinding


class UserDetailAdapter(items: LiveData<List<String>>, owner: LifecycleOwner, onClick: (View, String) -> Unit) :
    BaseAdapter<String, UserDetailItemBinding, BaseViewHolder<String, UserDetailItemBinding>>(
        items,
        owner,
        R.layout.item_user_detail,
        onClick
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        object : BaseViewHolder<String, UserDetailItemBinding>(inflate(parent), onClick) {}
}