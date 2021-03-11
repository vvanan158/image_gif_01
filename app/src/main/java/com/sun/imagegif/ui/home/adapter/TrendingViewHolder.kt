package com.sun.imagegif.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sun.imagegif.R
import com.sun.imagegif.data.model.Gif
import kotlinx.android.synthetic.main.item_gif_trending.view.*

class TrendingViewHolder(
    viewGroup: ViewGroup,
) : RecyclerView.ViewHolder(newInstance(viewGroup)) {

    fun onBind(gif: Gif) {
        with(itemView) {
            nameTextView.text = gif.title
            Glide.with(context)
                .asGif()
                .load(gif.imageUrl)
                .into(gifImageView)
        }
    }

    fun registerItemViewHolderListener(listener: (Int) -> Unit) {
        itemView.gifImageView.setOnClickListener {
            listener(adapterPosition)
        }
    }

    companion object {
        fun newInstance(viewGroup: ViewGroup): View {
            return LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_gif_trending, viewGroup, false)
        }
    }
}
