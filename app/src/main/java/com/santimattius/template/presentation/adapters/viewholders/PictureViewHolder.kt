package com.santimattius.template.presentation.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.santimattius.template.R
import com.santimattius.template.core.presentation.load
import com.santimattius.template.databinding.ItemPictureBinding
import com.santimattius.template.presentation.models.PictureUiModel

class PictureViewHolder(private val itemPictureBinding: ItemPictureBinding) :
    RecyclerView.ViewHolder(itemPictureBinding.root) {

    fun bind(item: PictureUiModel, onItemClick: (PictureUiModel) -> Unit = {}) {
        with(itemPictureBinding) {
            image.load(item.imageUrl)
            author.setAuthor(item.author)
            itemRootContainer.setOnClickListener { onItemClick(item) }
        }
    }

    private fun TextView.setAuthor(author: String) {
        this.text = context.getString(R.string.label_author, author)
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
