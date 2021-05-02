package com.santimattius.template.presentation.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.santimattius.template.presentation.adapters.diff.PictureDiffItem
import com.santimattius.template.presentation.adapters.viewholders.PictureViewHolder
import com.santimattius.template.presentation.models.PictureUiModel

class HomeAdapter(private val onItemClick: (PictureUiModel) -> Unit = {}) :
    ListAdapter<PictureUiModel, PictureViewHolder>(PictureDiffItem()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        return PictureViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClick)
    }
}



