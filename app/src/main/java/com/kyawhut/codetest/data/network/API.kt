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
        @Query("page[number]") page: Int = 1,
        @Query("page[size]") perPage: Int = 30,
        @Query("include") include: String = "featured_variant,featured_ad",
        @Query("filter[landing_page]") filterPage: String = "sale",
        @Query("include") includeOption: String = "brand,option_types.option_values,featured_variant,featured_ad",
        @Query("sort") sort: String = "sales",
    ): ProductResponse
}
