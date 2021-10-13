package com.kyawhut.codetest.base

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * @author kyawhtut
 * @date 10/13/21
 */
abstract class BaseActivity<VB : ViewDataBinding> : AppCompatActivity(), View.OnClickListener {

    abstract val layoutID: Int
    open val onClickName: Int = -1

    protected lateinit var vb: VB

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = DataBindingUtil.setContentView(this, layoutID)
        vb.apply {
            if (onClickName != -1) setVariable(onClickName, this@BaseActivity)
            lifecycleOwner = this@BaseActivity
            executePendingBindings()
        }
    }

    override fun onClick(v: View) {
    }
}
