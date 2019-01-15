package me.fonix232.tipyapp.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import me.fonix232.common.ui.adapter.BaseAdapter
import me.fonix232.common.ui.adapter.BaseViewHolder
import me.fonix232.tipyapp.R
import me.fonix232.tipyapp.bindings.UserItemBinding
import me.fonix232.tipyapp.model.User


class UsersAdapter(items: LiveData<List<User>>, owner: LifecycleOwner, onClick: (View, User) -> Unit):
    BaseAdapter<User, UserItemBinding, BaseViewHolder<User, UserItemBinding>>(items, owner, R.layout.item_user, onClick) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<User, UserItemBinding> =
            object:BaseViewHolder<User, UserItemBinding>(inflate(parent), onClick) {}
}

//
//class UsersAdapter(result: LiveData<Outcome<List<User>>>, onClick: (View, User) -> Unit) :
//    RxAdapter<User, UserItemBinding>(result, onClick, R.layout.item_user) {
//
//
//
//}