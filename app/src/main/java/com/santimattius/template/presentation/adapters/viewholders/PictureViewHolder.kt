package com.santimattius.template.presentation.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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

    private fun ImageView.load(url: String) {
        Glide.with(context).load(url).into(this)
    }

    companion object {

        fun from(parent: ViewGroup): PictureViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val viewBinding = ItemPictureBinding.inflate(
                inflater,
                parent,
                false
            )
            return PictureViewHolder(viewBinding)
        }

    }
}