package com.kyawhut.codetest.ui.detail

import androidx.lifecycle.MutableLiveData
import com.kyawhut.codetest.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author kyawhtut
 * @date 10/13/21
 */
@HiltViewModel
class DetailViewModel @Inject constructor() : BaseViewModel() {

    val orderCount: MutableLiveData<Int> = MutableLiveData(1)
}
