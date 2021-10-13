package com.kyawhut.codetest.data.network.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

/**
 * @author kyawhtut
 * @date 10/13/21
 */
@Keep
data class ProductResponse(
    @SerializedName("data")
    val productList: List<Data>,
    @SerializedName("included")
    val includedList: List<Data>,
    @SerializedName("meta")
    val meta: MetaResponse,
    @SerializedName("info")
    val info: Map<String, String>
) {

    @Keep
    data class Data(
        @SerializedName("id")
        val id: String,
        @SerializedName("type")
        val type: String,
        @SerializedName("attributes")
        val attributes: AttributesResponse,
        @SerializedName("relationships")
        val relationships: RelationshipsResponse
    )
}
