package com.kyawhut.codetest.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
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

        vb.apply {
            carouselItemList = listOf(
                "https://image-optimizer-reg.production.sephora-asia.net/images/product_images/featured_1_Product_811999022078-KVD-Vegan-Beauty-Tattoo-Liner-Liquid-Eyeliner--Mad-Max-Brown_fd595236eb2277c741344727d122f4d7d1ffe690_1593595572.png",
                "https://image-optimizer-reg.production.sephora-asia.net/images/product_images/featured_3_Product_811999022078-KVD-Vegan-Beauty-Mad-Max-Brown-_642cab2e2099dc997cd6521dca1e8dfd8b230910_1583915188.png",
                "https://image-optimizer-reg.production.sephora-asia.net/images/product_images/featured_1_Product_811999022078-KVD-Vegan-Beauty-Tattoo-Liner-Liquid-Eyeliner--Mad-Max-Brown_fd595236eb2277c741344727d122f4d7d1ffe690_1593595572.png",
                "https://image-optimizer-reg.production.sephora-asia.net/images/product_images/featured_3_Product_811999022078-KVD-Vegan-Beauty-Mad-Max-Brown-_642cab2e2099dc997cd6521dca1e8dfd8b230910_1583915188.png",
            )
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
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

    override fun onResume() {
        super.onResume()
        vb.viewCarousel.onResume()
    }

    override fun onPause() {
        super.onPause()
        vb.viewCarousel.onPause()
    }
}
