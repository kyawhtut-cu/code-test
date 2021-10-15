package com.kyawhut.codetest.ui.sale

import com.kyawhut.codetest.data.model.ProductModel
import com.kyawhut.codetest.data.network.request.ProductRequest
import com.kyawhut.codetest.data.network.response.MetaResponse
import com.kyawhut.codetest.utils.network.NetworkResponse

/**
 * @author kyawhtut
 * @date 10/13/21
 */
interface SaleRepository {

    suspend fun fetchSaleList(
        productRequest: ProductRequest,
        callback: (NetworkResponse<Pair<List<ProductModel>, MetaResponse>>) -> Unit
    )
}
