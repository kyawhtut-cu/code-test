package com.kyawhut.codetest.ui.sale

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kyawhut.codetest.BR
import com.kyawhut.codetest.R
import com.kyawhut.codetest.base.BaseFragmentWithVM
import com.kyawhut.codetest.databinding.FragmentSaleBinding
import com.kyawhut.codetest.ui.home.HomeActivity
import com.kyawhut.codetest.utils.extension.onLoadMoreEnd
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        vm.openDetailScreen = { pos, item ->
            findNavController().navigate(
                SaleFragmentDirections.actionSaleFragmentToDetailFragment(item)
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        findNavController()

        vb.apply {
            viewModel = vm
            rvItem.onLoadMoreEnd {
                vm.onLoadMore()
            }
            executePendingBindings()
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.sale_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_search -> {
                Toast.makeText(context, "Clicked Search", Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
