package com.kyawhut.codetest.ui.zoom

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.kyawhut.codetest.R
import com.kyawhut.codetest.base.BaseFragment
import com.kyawhut.codetest.data.model.CategoryImageModel
import com.kyawhut.codetest.databinding.FragmentZoomImageBinding
import com.kyawhut.codetest.rv.adapter.CategoryImageAdapter
import com.kyawhut.codetest.ui.home.HomeActivity

/**
 * @author kyawhtut
 * @date 10/15/21
 */
class ZoomImageFragment : BaseFragment<FragmentZoomImageBinding>() {

    private val args: ZoomImageFragmentArgs by navArgs()

    override val layoutID: Int
        get() = R.layout.fragment_zoom_image

    private val categoryImageAdapter: CategoryImageAdapter by lazy {
        CategoryImageAdapter { index, item ->
            if (item.isSelected) return@CategoryImageAdapter
            vb.selectedImageURL = args.zoomImageList[index]
            categoryImageAdapter.updateSelectedIndex(index)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as HomeActivity).supportActionBar?.title = args.brandName

        categoryImageAdapter.addAll(args.categoryImageList.mapIndexed { index, s ->
            CategoryImageModel(s, index == args.selectedIndex)
        })

        vb.apply {
            categoryAdapter = categoryImageAdapter
            selectedImageURL = args.zoomImageList[args.selectedIndex]
            executePendingBindings()
        }
    }
}
