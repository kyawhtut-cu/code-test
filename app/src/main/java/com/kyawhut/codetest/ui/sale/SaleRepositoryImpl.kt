package com.kyawhut.codetest.ui.sale

import com.kyawhut.codetest.data.network.API
import com.kyawhut.codetest.data.network.response.ProductResponse
import com.kyawhut.codetest.utils.network.NetworkResponse
import com.kyawhut.codetest.utils.network.execute
import javax.inject.Inject

/**
 * @author kyawhtut
 * @date 10/13/21
 */
class SaleRepositoryImpl @Inject constructor(private val api: API) : SaleRepository {

    override suspend fun fetchSaleList(
        page: Int,
        callback: (NetworkResponse<ProductResponse>) -> Unit
    ) {
        NetworkResponse.loading(callback)
        val response = execute {
            api.getProductList(page)
        }
        if (response.isSuccess) {
            response.post(callback)
        } else response.post(callback)
    }
}
