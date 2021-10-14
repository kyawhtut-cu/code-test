package com.kyawhut.codetest.data.model

import com.kyawhut.codetest.data.network.response.ProductResponse

/**
 * @author kyawhtut
 * @date 10/14/21
 */
data class ProductModel(
    val productImage: String,
    val productBrandName: String,
    val productName: String,
    val productOriginalPrice: String,
    val productDiscountPrice: String,
    val productDiscountRate: String,
    val productRate: Float,
    val productShades: Int,
    var isFavorite: Boolean,
) {
    companion object {
        fun ProductResponse.Data.toProductModel(): ProductModel = ProductModel(
            attributes.defaultImageList?.get(0) ?: "",
            attributes.brandName ?: "",
            attributes.name ?: "",
            attributes.displayOriginalPrice ?: "",
            attributes.displayPrice ?: "",
            attributes.saleText?.replace("OFF", "") ?: "",
            attributes.rating ?: 0f,
            attributes.variantsCount ?: 0,
            false
        )
    }
}
