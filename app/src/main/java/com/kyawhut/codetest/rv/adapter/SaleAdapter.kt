package com.kyawhut.codetest.rv.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.kyawhut.codetest.R
import com.kyawhut.codetest.base.BaseAdapter
import com.kyawhut.codetest.base.BaseViewHolder
import com.kyawhut.codetest.data.model.ProductModel
import com.kyawhut.codetest.rv.viewholder.SaleViewHolder

/**
 * @author kyawhtut
 * @date 10/13/21
 */
class SaleAdapter(
    itemClickListener: (Int, ProductModel) -> Unit = { _, _ -> },
    private val onFavoriteClickListener: (Int, ProductModel) -> Unit,
) : BaseAdapter<ProductModel>(itemClickListener) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*, ProductModel> {
        return SaleViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.card_sale_item, parent, false
            ),
            itemClickListener,
            onFavoriteClickListener,
        )
    }
}
