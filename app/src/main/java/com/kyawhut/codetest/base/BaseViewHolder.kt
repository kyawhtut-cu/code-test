package com.kyawhut.codetest.base

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * @author kyawhtut
 * @date 10/13/21
 */
abstract class BaseViewHolder<VB : ViewDataBinding, D>(
    protected val vb: VB,
    private val itemClickListener: (Int, D) -> Unit = { _, _ -> },
) : RecyclerView.ViewHolder(vb.root), View.OnClickListener {

    open val onClickListener: Int = -1

    var data: D? = null

    init {
        vb.apply {
            if (onClickListener != -1) setVariable(onClickListener, this@BaseViewHolder)
            root.setOnClickListener {
                data?.let {
                    itemClickListener.invoke(adapterPosition, it)
                }
            }
            executePendingBindings()
        }
    }

    abstract fun bind()

    override fun onClick(v: View) {
    }
}
