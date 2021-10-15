package com.kyawhut.codetest.data.network

import com.kyawhut.codetest.data.network.response.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author kyawhtut
 * @date 10/13/21
 */
interface API {

    @GET("v2.5/products")
    suspend fun getProductList(
        @Query("page[number]") page: Int,
        @Query("page[size]") perPage: Int,
        @Query("include") include: String,
        @Query("filter[landing_page]") filterPage: String,
        @Query("include") includeOption: String,
        @Query("sort") sort: String,
    ): ProductResponse
}
