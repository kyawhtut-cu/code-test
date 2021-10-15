package com.kyawhut.codetest.ui.detail

import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.text.HtmlCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kyawhut.codetest.BR
import com.kyawhut.codetest.R
import com.kyawhut.codetest.base.BaseFragmentWithVM
import com.kyawhut.codetest.data.model.CategoryImageModel
import com.kyawhut.codetest.databinding.FragmentDetailBinding
import com.kyawhut.codetest.rv.adapter.CategoryImageAdapter
import com.kyawhut.codetest.ui.home.HomeActivity
import com.kyawhut.codetest.ui.popup.showPopupMenuBuilder
import com.kyawhut.codetest.utils.extension.Extension.getColor
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

    private val args: DetailFragmentArgs by navArgs()

    private val categoryAdapter: CategoryImageAdapter by lazy {
        CategoryImageAdapter { index, item ->
            if (item.isSelected) return@CategoryImageAdapter
            vb.viewCarousel.currentItem = index
            categoryAdapter.updateSelectedIndex(index)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as HomeActivity).supportActionBar?.title =
            args.productModel.productBrandName

        categoryAdapter.clear()
        categoryAdapter.addAll(args.productModel.productCategoryList.mapIndexed { index, s ->
            CategoryImageModel(s, index == 0)
        })

        vb.apply {
            viewModel = vm
            productModel = args.productModel
            isFavorite = args.productModel.isFavorite
            categoryAdapter = this@DetailFragment.categoryAdapter
            viewCarousel.setOnCarouselChangeListener {
                this@DetailFragment.categoryAdapter.updateSelectedIndex(it)
            }
            tvFunction.text = getSpannableString(
                getString(R.string.lbl_function),
                getString(R.string.lbl_function_dummy)
            )
            tvSkinType.text = getSpannableString(
                getString(R.string.lbl_skin_type),
                getString(R.string.lbl_skin_type_dummy)
            )
            tvFinish.text = getSpannableString(
                getString(R.string.lbl_finish),
                getString(R.string.lbl_finish_dummy)
            )
            tvFormulation.text = getSpannableString(
                getString(R.string.lbl_formulation),
                getString(R.string.lbl_formulation_dummy)
            )
            tvWhatItIs.text = HtmlCompat.fromHtml(
                args.productModel.productDescription,
                HtmlCompat.FROM_HTML_MODE_LEGACY
            )
            tvWhatItDoes.text = HtmlCompat.fromHtml(
                args.productModel.productHowToText,
                HtmlCompat.FROM_HTML_MODE_LEGACY
            )
            executePendingBindings()
        }
    }

    private fun getSpannableString(firstString: String, secondString: String): SpannableString {
        val spannable = SpannableString("$firstString $secondString")
        spannable.setSpan(
            ForegroundColorSpan(
                requireContext() getColor R.color.colorDiscountRate
            ),
            0,
            firstString.length,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return spannable
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.action_add_to_fav -> {
                args.productModel.isFavorite = args.productModel.isFavorite
                vb.isFavorite = args.productModel.isFavorite
            }
            R.id.action_order_count -> {
                showPopupMenuBuilder(
                    getString(R.string.lbl_choose_count),
                    (0 until 10).map {
                        "${it + 1}"
                    }
                ).setOnMenuClickListener {
                    vm.orderCount.postValue(it.toInt())
                }.show(v)
            }
            R.id.action_add_to_bag -> {
            }
            R.id.action_zoom -> {
                findNavController().navigate(
                    DetailFragmentDirections.detailToZoomImage(
                        args.productModel.productZoomImageList.toTypedArray(),
                        args.productModel.productCategoryList.toTypedArray(),
                        args.productModel.productBrandName,
                        vb.viewCarousel.currentItem
                    )
                )
            }
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
