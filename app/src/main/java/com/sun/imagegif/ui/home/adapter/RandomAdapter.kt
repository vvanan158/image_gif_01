package com.sun.imagegif.ui.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.imagegif.data.model.Gif

class RandomAdapter : RecyclerView.Adapter<RandomViewHolder>() {

    private val gifs = mutableListOf<Gif>()
    private var listener: ((Gif) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomViewHolder {
        return RandomViewHolder(parent).apply {
            registerItemViewHolderListener {
                listener?.let { func -> func(gifs[it]) }
            }
        }
    }

    override fun onBindViewHolder(holder: RandomViewHolder, position: Int) {
        holder.onBind(gifs[position])
    }

    override fun getItemCount() = gifs.size

    fun addRandom(items: MutableList<Gif>?) {
        items?.let {
            gifs.addAll(it)
            notifyItemRangeInserted(this.gifs.size - it.size, it.size)
        }
    }

    fun setOnClickItemListener(listener: ((Gif) -> Unit)) {
        this.listener = listener
    }
}
