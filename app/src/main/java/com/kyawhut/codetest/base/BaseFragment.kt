package com.kyawhut.codetest.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * @author kyawhtut
 * @date 10/13/21
 */
abstract class BaseFragment<VB : ViewDataBinding> : Fragment(), View.OnClickListener {

    abstract val layoutID: Int
    open val onClickListener: Int = -1
    protected lateinit var vb: VB

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vb = DataBindingUtil.inflate(inflater, layoutID, container, false)
        vb.apply {
            if (onClickListener != -1) setVariable(onClickListener, this@BaseFragment)
            executePendingBindings()
        }
        return vb.root
    }

    override fun onClick(v: View) {
    }
}
