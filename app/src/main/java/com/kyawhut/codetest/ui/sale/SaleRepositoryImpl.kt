package com.kyawhut.codetest.ui.sale

import com.kyawhut.codetest.data.model.ProductModel
import com.kyawhut.codetest.data.model.ProductModel.Companion.toProductModel
import com.kyawhut.codetest.data.network.API
import com.kyawhut.codetest.data.network.request.ProductRequest
import com.kyawhut.codetest.data.network.response.MetaResponse
import com.kyawhut.codetest.utils.network.NetworkResponse
import com.kyawhut.codetest.utils.network.execute
import javax.inject.Inject

/**
 * @author kyawhtut
 * @date 10/13/21
 */
class SaleRepositoryImpl @Inject constructor(private val api: API) : SaleRepository {

    override suspend fun fetchSaleList(
        productRequest: ProductRequest,
        callback: (NetworkResponse<Pair<List<ProductModel>, MetaResponse>>) -> Unit
    ) {
        NetworkResponse.loading(callback)
        val response = execute {
            api.getProductList(
                productRequest.page,
                productRequest.perPage,
                productRequest.include,
                productRequest.filterPage,
                productRequest.includeOption,
                productRequest.sort,
            )
        }
        if (response.isSuccess) {
            NetworkResponse.success((response.data?.productList?.map {
                it.toProductModel()
            } ?: listOf()) to response.data?.meta!!, callback)
        } else NetworkResponse.error(response.error, callback)
    }
}
