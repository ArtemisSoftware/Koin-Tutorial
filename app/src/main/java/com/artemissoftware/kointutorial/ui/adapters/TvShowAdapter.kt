package com.artemissoftware.kointutorial.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.artemissoftware.kointutorial.R
import com.artemissoftware.kointutorial.api.models.TvShow
import kotlinx.android.synthetic.main.item_tv_show.view.*

class TvShowAdapter : ListAdapter<TvShow, TvShowAdapter.TvShowViewHolder>(TvShowDiffCallback()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        return TvShowViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_tv_show, parent, false))
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {

        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }


     class TvShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(tvShow: TvShow) {

            itemView.txt_title.text = tvShow.name
            itemView.img_poster.load(tvShow.image.original) {
                crossfade(true)
                crossfade(5000)
            }
        }
    }



}