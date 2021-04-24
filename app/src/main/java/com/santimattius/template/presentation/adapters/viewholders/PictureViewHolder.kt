package com.santimattius.template.presentation.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.santimattius.template.databinding.ItemPictureBinding
import com.santimattius.template.presentation.models.PictureUiModel

class PictureViewHolder(private val itemPictureBinding: ItemPictureBinding) :
    RecyclerView.ViewHolder(itemPictureBinding.root) {

    fun bind(item: PictureUiModel) {
        with(itemPictureBinding) {
            image.load(item.url)
            author.text = item.author
        }
    }

    //TODO: add Glide - extract extensions
    private fun ImageView.load(url: String) {

    }

    companion object {

        //TODO: refactor
        fun from(parent: ViewGroup) =
            PictureViewHolder(
                ItemPictureBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
    }
}