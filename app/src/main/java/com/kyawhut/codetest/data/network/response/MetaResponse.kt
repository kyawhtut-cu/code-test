package com.kyawhut.codetest.data.network.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

/**
 * @author kyawhtut
 * @date 10/13/21
 */
@Keep
data class MetaResponse(
    @SerializedName("total")
    val total: Int,
    @SerializedName("total-pages")
    val totalPage: Int,
    @SerializedName("total-items")
    val totalItems: Int,
    @SerializedName("current-page")
    val currentPage: Int,
    @SerializedName("per-page")
    val perPage: Int,
    @SerializedName("landing-page-name")
    val landingPageName: String,
)
