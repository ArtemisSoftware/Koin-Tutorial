package com.artemissoftware.kointutorial.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.artemissoftware.kointutorial.api.models.TvShow

class TvShowDiffCallback : DiffUtil.ItemCallback<TvShow>() {
    override fun areItemsTheSame(oldItem: TvShow, newItem: TvShow) =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: TvShow, newItem: TvShow) =
        oldItem == newItem
}