package com.kyawhut.codetest.base

import androidx.databinding.ViewDataBinding

/**
 * @author kyawhtut
 * @date 10/13/21
 */
abstract class BaseFragmentWithVM<VB : ViewDataBinding, VM : BaseViewModel> : BaseFragment<VB>() {

    abstract val vm: VM
}
