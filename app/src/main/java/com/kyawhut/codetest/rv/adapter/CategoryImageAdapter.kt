package com.kyawhut.codetest.rv.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kyawhut.codetest.base.BaseAdapter
import com.kyawhut.codetest.base.BaseViewHolder
import com.kyawhut.codetest.data.model.CategoryImageModel
import com.kyawhut.codetest.databinding.CardImageBinding

/**
 * @author kyawhtut
 * @date 10/15/21
 */
class CategoryImageAdapter(
    itemClickListener: (Int, CategoryImageModel) -> Unit
) : BaseAdapter<CategoryImageModel>(itemClickListener) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*, CategoryImageModel> {
        return CategoryImageViewHolder(
            CardImageBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            itemClickListener
        )
    }
}
