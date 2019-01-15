package me.fonix232.tipyapp.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.recyclerview.widget.RecyclerView
import me.fonix232.common.ui.adapter.BaseViewHolder

abstract class RxAdapter<T : Any, B : ViewDataBinding>(
    protected val result: LiveData<Outcome<List<T>>>,
    protected val onClick: (View, T) -> Unit,
    @LayoutRes protected val layout: Int
) : RecyclerView.Adapter<BaseViewHolder<T, B>>() {

    private val items = MediatorLiveData<List<T>>()

    init {
        items.addSource(result) { outcome ->

            when (outcome) {
                is Outcome.Success -> {
                    items.postValue(outcome.data)
                    notifyDataSetChanged()
                }
                is Outcome.Failure -> {
                    items.postValue(null)
                    notifyDataSetChanged()
                }
                is Outcome.Progress -> {
                }
            }
        }
    }

    override fun getItemCount(): Int = items.value?.size ?: 0

    override fun onBindViewHolder(holder: BaseViewHolder<T, B>, position: Int) {
        holder.bind(getItem(position))
    }

    protected open fun getItem(position: Int): T? = items.value?.get(position)

    protected open fun inflate(parent: ViewGroup): B =
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), layout, parent, false)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        object : BaseViewHolder<T, B>(inflate(parent), onClick) {}
}