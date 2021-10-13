package com.kyawhut.codetest.ui.sale

import com.kyawhut.codetest.data.network.response.ProductResponse
import com.kyawhut.codetest.utils.network.NetworkResponse

/**
 * @author kyawhtut
 * @date 10/13/21
 */
interface SaleRepository {

    suspend fun fetchSaleList(page: Int, callback: (NetworkResponse<ProductResponse>) -> Unit)
}
