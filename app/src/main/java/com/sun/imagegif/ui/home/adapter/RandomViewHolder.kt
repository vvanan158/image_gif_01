package com.sun.imagegif.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sun.imagegif.R
import com.sun.imagegif.data.model.Gif
import com.sun.imagegif.utils.OnItemViewHolderClickListener
import kotlinx.android.synthetic.main.item_gif_random.view.*

class RandomViewHolder(
    viewGroup: ViewGroup,
    private val listener: OnItemViewHolderClickListener<Gif>
) : RecyclerView.ViewHolder(newInstance(viewGroup)) {

    fun onBind(gif: Gif) {
        with(itemView) {
            relatedImageView.setOnClickListener {
                listener.onItemClickListener(gif)
            }
            Glide.with(context)
                .asGif()
                .load(gif.imageUrl)
                .into(relatedImageView)
        }
    }

    companion object {
        fun newInstance(viewGroup: ViewGroup): View {
            return LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_gif_random, viewGroup, false)
        }
    }
}
