package com.kyawhut.codetest.rv.adapter

import com.kyawhut.codetest.base.BaseViewHolder
import com.kyawhut.codetest.data.model.CategoryImageModel
import com.kyawhut.codetest.databinding.CardImageBinding

/**
 * @author kyawhtut
 * @date 10/15/21
 */
class CategoryImageViewHolder(
    vb: CardImageBinding,
    itemClickListener: (Int, CategoryImageModel) -> Unit,
) : BaseViewHolder<CardImageBinding, CategoryImageModel>(vb, itemClickListener) {

    override fun bind() {
        vb.apply {
            imageURL = data!!.imageURL
            root.isSelected = data!!.isSelected
            executePendingBindings()
        }
    }
}
