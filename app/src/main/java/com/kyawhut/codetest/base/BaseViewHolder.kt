package com.kyawhut.codetest.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * @author kyawhtut
 * @date 10/13/21
 */
abstract class BaseViewHolder<VB : ViewDataBinding, D>(
    protected val vb: VB
) : RecyclerView.ViewHolder(vb.root) {

    abstract fun bind(data: D)
}
