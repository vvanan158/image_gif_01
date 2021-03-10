package com.sun.imagegif.ui.search.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.imagegif.data.model.Gif

class SearchAdapter : RecyclerView.Adapter<SearchViewHolder>() {

    private val gifs = mutableListOf<Gif>()
    private var listener: ((Gif) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(parent).apply {
            registerItemViewHolderListener {
                listener?.let { func -> func(gifs[it]) }
            }
        }
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.onBind(gifs[position])
    }

    override fun getItemCount() = gifs.size

    fun updateData(items: MutableList<Gif>?) {
        items?.let {
            gifs.clear()
            gifs.addAll(it)
            notifyDataSetChanged()
        }
    }

    fun setOnClickItemListener(listener: ((Gif) -> Unit)?) {
        this.listener = listener
    }
}
