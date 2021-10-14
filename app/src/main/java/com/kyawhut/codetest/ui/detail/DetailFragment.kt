package com.kyawhut.codetest.ui.detail

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
import com.kyawhut.codetest.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author kyawhtut
 * @date 10/13/21
 */
@AndroidEntryPoint
class DetailFragment : BaseFragmentWithVM<FragmentDetailBinding, DetailViewModel>() {

    override val layoutID: Int
        get() = R.layout.fragment_detail

    override val onClickListener: Int
        get() = BR.onClickListener

    override val vm: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_second -> findNavController().navigate(R.id.action_DetailFragment_to_SaleFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.detail_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                Toast.makeText(context, "Clicked Share", Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
