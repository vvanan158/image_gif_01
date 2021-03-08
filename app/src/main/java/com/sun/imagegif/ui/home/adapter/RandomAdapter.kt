package com.sun.imagegif.ui.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.imagegif.data.model.Gif
import com.sun.imagegif.utils.OnItemRecyclerViewClickListener
import com.sun.imagegif.utils.OnItemViewHolderClickListener

class RandomAdapter : RecyclerView.Adapter<RandomViewHolder>(),
    OnItemViewHolderClickListener<Gif> {

    private val items = mutableListOf<Gif>()
    private var listener: OnItemRecyclerViewClickListener<Gif>? = null

    fun addRandom(items: MutableList<Gif>?) {
        items?.let {
            this.items.addAll(it)
            notifyItemRangeInserted(this.items.size - it.size, it.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomViewHolder {
        return RandomViewHolder(parent, this)
    }

    override fun onBindViewHolder(holder: RandomViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount() = items.size

    override fun onItemClickListener(item: Gif?) {
        listener?.onItemClickListener(item)
    }

    fun registerItemRecyclerViewClickListener(onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<Gif>?) {
        listener = onItemRecyclerViewClickListener
    }
}
