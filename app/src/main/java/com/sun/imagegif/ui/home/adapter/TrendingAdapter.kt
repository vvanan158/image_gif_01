package com.sun.imagegif.ui.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.imagegif.data.model.Gif

class TrendingAdapter : RecyclerView.Adapter<TrendingViewHolder>() {

    private val gifs = mutableListOf<Gif>()
    private var listener: ((Gif) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        return TrendingViewHolder(parent).apply {
            registerItemViewHolderListener {
                listener?.let { func -> func(gifs[it]) }
            }
        }
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        holder.onBind(gifs[position])
    }

    override fun getItemCount() = gifs.size

    fun addTrending(items: MutableList<Gif>?) {
        items?.let {
            gifs.addAll(it)
            notifyItemRangeInserted(this.gifs.size - it.size, it.size)
        }
    }

    fun setOnClickItemListener(listener: (Gif) -> Unit) {
        this.listener = listener
    }
}
