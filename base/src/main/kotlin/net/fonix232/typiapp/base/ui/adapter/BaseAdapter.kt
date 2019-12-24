package net.fonix232.typiapp.base.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import net.fonix232.typiapp.base.BR

class BaseAdapter<T>(
    @LayoutRes val layout: Int,
    private val diff: DiffCallback<T>? = null,
    private val onClick: ((T) -> Unit)? = null
) : RecyclerView.Adapter<BaseAdapter<T>.ViewHolder>() {

    constructor(@LayoutRes layout: Int, onClick: ((T) -> Unit)? = null) : this(layout, null, onClick)

    var items: List<T> = listOf()
        set(value) {
            if (diff != null) {
                diff.oldItems = field
                diff.newItems = value

                val result = DiffUtil.calculateDiff(diff)
                field = value
                result.dispatchUpdatesTo(this)
            } else {
                field = value
                notifyDataSetChanged()
            }
        }

    inner class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener { item?.let { onClick?.invoke(it) } }
        }

        var item: T? = null
            set(value) {
                field = value
                // TODO: Fix binding assignment
                binding.setVariable(BR.item, value)
                binding.executePendingBindings()
            }
    }

    abstract class DiffCallback<T> : DiffUtil.Callback() {
        abstract var oldItems: List<T>
        abstract var newItems: List<T>

        override fun getOldListSize(): Int = oldItems.size
        override fun getNewListSize(): Int = newItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), layout, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item = items[position]
    }
}
