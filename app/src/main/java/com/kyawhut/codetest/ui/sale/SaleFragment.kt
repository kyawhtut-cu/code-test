package com.kyawhut.codetest.ui.sale

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kyawhut.codetest.BR
import com.kyawhut.codetest.R
import com.kyawhut.codetest.base.BaseFragmentWithVM
import com.kyawhut.codetest.databinding.FragmentSaleBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author kyawhtut
 * @date 10/13/21
 */
@AndroidEntryPoint
class SaleFragment : BaseFragmentWithVM<FragmentSaleBinding, SaleViewModel>() {

    override val layoutID: Int
        get() = R.layout.fragment_sale

    override val onClickListener: Int
        get() = BR.onClickListener

    override val vm: SaleViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_first -> findNavController().navigate(R.id.action_SaleFragment_to_DetailFragment)
        }
    }
}
