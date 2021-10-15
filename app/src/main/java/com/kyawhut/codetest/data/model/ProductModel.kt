package com.kyawhut.codetest.data.model

import com.kyawhut.codetest.data.network.response.ProductResponse
import java.io.Serializable

/**
 * @author kyawhtut
 * @date 10/14/21
 */
data class ProductModel(
    val productImage: String,
    val productBrandName: String,
    val productName: String,
    val productDescription: String,
    val productHowToText: String,
    val productOriginalPrice: String,
    val productDiscountPrice: String,
    val productDiscountRate: String,
    val productRate: Float,
    val productShades: Int,
    val productReviewCount: Int,
    val productCarouselList: List<String>,
    val productCategoryList: List<String>,
    var isFavorite: Boolean,
) : Serializable {
    companion object {
        fun ProductResponse.Data.toProductModel(): ProductModel = ProductModel(
            attributes.defaultImageList?.get(0) ?: "",
            attributes.brandName ?: "",
            attributes.name ?: "",
            attributes.description ?: "",
            attributes.howToText ?: "",
            attributes.displayOriginalPrice ?: "",
            attributes.displayPrice ?: "",
            attributes.saleText?.replace("OFF", "") ?: "",
            attributes.rating ?: 0f,
            attributes.variantsCount ?: 0,
            attributes.reviewsCount ?: 0,
            attributes.imageList ?: listOf(),
            attributes.cartImageList ?: listOf(),
            false
        )
    }
}
