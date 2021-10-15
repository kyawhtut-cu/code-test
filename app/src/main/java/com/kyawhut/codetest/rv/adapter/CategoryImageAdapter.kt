package com.kyawhut.codetest.rv.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kyawhut.codetest.base.BaseAdapter
import com.kyawhut.codetest.base.BaseViewHolder
import com.kyawhut.codetest.data.model.CategoryImageModel
import com.kyawhut.codetest.databinding.CardImageBinding
import com.kyawhut.codetest.rv.viewholder.CategoryImageViewHolder

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

    fun updateSelectedIndex(index: Int) {
        // todo: update old selected item to unselected
        update(
            indexOfFirst { it.isSelected },
            get { it.isSelected }.apply {
                isSelected = false
            }
        )
        // todo: update clicked item to show selected
        update(
            index,
            get(index)!!.apply {
                isSelected = true
            }
        )
    }
}
