package com.kyawhut.codetest.rv.viewholder

import android.view.View
import com.kyawhut.codetest.BR
import com.kyawhut.codetest.R
import com.kyawhut.codetest.base.BaseViewHolder
import com.kyawhut.codetest.data.model.ProductModel
import com.kyawhut.codetest.databinding.CardSaleItemBinding

/**
 * @author kyawhtut
 * @date 10/13/21
 */
class SaleViewHolder(
    vb: CardSaleItemBinding,
    itemClickListener: (Int, ProductModel) -> Unit = { _, _ -> },
    private val onFavoriteClickListener: (Int, ProductModel) -> Unit,
) : BaseViewHolder<CardSaleItemBinding, ProductModel>(vb, itemClickListener) {

    override val onClickListener: Int
        get() = BR.onClickListener

    override fun bind() {
        vb.apply {
            product = data
            executePendingBindings()
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.action_add_to_fav -> onFavoriteClickListener(adapterPosition, data!!)
        }
    }
}
