package com.kyawhut.codetest.ui.detail

import androidx.lifecycle.SavedStateHandle
import com.kyawhut.codetest.base.BaseViewModel
import com.kyawhut.codetest.data.model.ProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author kyawhtut
 * @date 10/13/21
 */
@HiltViewModel
class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    val productModel: ProductModel? by lazy {
        savedStateHandle.get("product_model") as ProductModel?
    }
}
