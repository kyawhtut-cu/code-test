package com.kyawhut.codetest.ui.sale

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.kyawhut.codetest.base.BaseViewModel
import com.kyawhut.codetest.data.network.response.ProductResponse
import com.kyawhut.codetest.rv.adapter.SaleAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author kyawhtut
 * @date 10/13/21
 */
@HiltViewModel
class SaleViewModel @Inject constructor(
    private val application: Application,
    private val repository: SaleRepository
) : BaseViewModel() {

    private var page: Int = 1
    private var totalPage: Int = 0

    val loadingState: MutableLiveData<Boolean> = MutableLiveData(false)
    val totalItemCount: MutableLiveData<Int> = MutableLiveData(0)

    var openDetailScreen: ((Int, ProductResponse.Data) -> Unit)? = null

    val saleAdapter: SaleAdapter by lazy {
        SaleAdapter(
            itemClickListener = { pos, item ->
                openDetailScreen?.invoke(pos, item)
            },
            onFavoriteClickListener = { pos, item ->
                Toast.makeText(application, "Clicked Favorite => $pos", Toast.LENGTH_LONG).show()
            }
        )
    }

    init {
        fetchProductList()
    }

    private fun fetchProductList() {
        viewModelScope {
            repository.fetchSaleList(page) {
                loadingState.postValue(it.isLoading)
                if (it.isSuccess) {
                    if (page == 1) saleAdapter.clear()
                    saleAdapter.addAll(it.data?.productList ?: listOf())
                    page += 1
                    totalPage = it.data?.meta?.totalPage ?: 0
                    totalItemCount.postValue(it.data?.meta?.totalItems ?: 0)
                } else {
                    // todo: show error view state
                }
            }
        }
    }

    fun onLoadMore() {
        if (page > totalPage) return
        fetchProductList()
    }

    fun onRefreshListener() {
        page = 1
        fetchProductList()
    }
}
