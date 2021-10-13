package com.kyawhut.codetest.base

import androidx.databinding.ViewDataBinding

/**
 * @author kyawhtut
 * @date 10/13/21
 */
abstract class BaseActivityWithVM<VB : ViewDataBinding, VM : BaseViewModel> : BaseActivity<VB>() {

    abstract val vm: VM

}
