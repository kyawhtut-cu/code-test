package com.kyawhut.codetest.rv.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.kyawhut.codetest.R
import com.kyawhut.codetest.base.BaseAdapter
import com.kyawhut.codetest.base.BaseViewHolder
import com.kyawhut.codetest.data.network.response.ProductResponse
import com.kyawhut.codetest.rv.viewholder.SaleViewHolder

/**
 * @author kyawhtut
 * @date 10/13/21
 */
class SaleAdapter(
    itemClickListener: (Int, ProductResponse.Data) -> Unit = { _, _ -> },
    private val onFavoriteClickListener: (Int, ProductResponse.Data) -> Unit,
) : BaseAdapter<ProductResponse.Data>(itemClickListener) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*, ProductResponse.Data> {
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
