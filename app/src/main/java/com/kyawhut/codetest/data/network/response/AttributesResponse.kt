package com.kyawhut.codetest.data.network.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

/**
 * @author kyawhtut
 * @date 10/13/21
 */
@Keep
data class AttributesResponse(
    @SerializedName("value")
    val value: String?,
    @SerializedName("option-type-id")
    val typeID: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug-url")
    val slugURL: String?,
    @SerializedName("sephora-id")
    val sephoraID: String?,
    @SerializedName("original-price")
    val originalPrice: Long?,
    @SerializedName("display-original-price")
    val displayOriginalPrice: String?,
    @SerializedName("price")
    val price: Long?,
    @SerializedName("display-price")
    val displayPrice: String?,
    @SerializedName("under-sale")
    val underSale: Boolean?,
    @SerializedName("sale-text")
    val saleText: String?,
    @SerializedName("inventory")
    val inventory: Int?,
    @SerializedName("icon-url")
    val iconURL: String?,
    @SerializedName("image-url")
    val imageURL: String?,
    @SerializedName("image-urls-without-fallbacks")
    val imageURLList: List<String>?,
    @SerializedName("pictures-count")
    val picturesCount: Int?,
    @SerializedName("cart-image-url")
    val cartImageURL: String?,
    @SerializedName("zoom-image-url")
    val zoomImageURL: String?,
    @SerializedName("reviews-count")
    val reviewsCount: Int?,
    @SerializedName("available-platforms")
    val availablePlatform: List<String>?,
    @SerializedName("labels")
    val labels: List<Any>?,
    @SerializedName("new-arrival")
    val newArrival: Boolean?,
    @SerializedName("sold-out")
    val soldOut: Boolean?,
    @SerializedName("rating")
    val rating: Float,
    @SerializedName("variants-count")
    val variantsCount: Int,
    @SerializedName("description")
    val description: String?,
    @SerializedName("how-to-text")
    val howToText: String?,
    @SerializedName("how-to")
    val howTo: String?,
    @SerializedName("benefits")
    val benefits: String?,
    @SerializedName("application")
    val application: String?,
    @SerializedName("ingredients")
    val ingredients: String?,
    @SerializedName("option-type-categories")
    val optionTypeCategories: List<String>?,
    @SerializedName("web-url")
    val webURL: String?,
    @SerializedName("state")
    val state: String?,
    @SerializedName("seo")
    val seo: HashMap<String, String?>?,
    @SerializedName("position")
    val position: Int?,
    @SerializedName("cart-image-urls")
    val cartImageList: List<String>?,
    @SerializedName("zoom-image-urls")
    val zoomImageList: List<String>?,
    @SerializedName("icon-image-urls")
    val iconImageList: List<String>?,
    @SerializedName("default-image-urls")
    val defaultImageList: List<String>?,
    @SerializedName("image-urls")
    val imageList: List<String>?,
    @SerializedName("closeup-image-urls")
    val closeupImageList: List<String>?,
    @SerializedName("featured-image-urls")
    val featuredImageList: List<String>?,
    @SerializedName("featured-variant-id")
    val featuredVariantID: Int?,
    @SerializedName("wishlisted")
    val wishlisted: Boolean?,
    @SerializedName("waitlisted")
    val waitlisted: Boolean?,
    @SerializedName("available-on-modiface")
    val availableOnModiface: Boolean?,
    @SerializedName("available-on-findation")
    val availableOnFindation: Boolean?,
    @SerializedName("findation-id")
    val findationID: Any?,
    @SerializedName("size")
    val size: String?,
    @SerializedName("product-name")
    val productName: String?,
    @SerializedName("brand-name")
    val brandName: String?,
    @SerializedName("brand-slug-url")
    val brandSlugURL: String?,
    @SerializedName("available")
    val available: Boolean?,
    @SerializedName("upc")
    val upc: String?,
    @SerializedName("sticker")
    val sticker: Boolean?,
    @SerializedName("translated-names")
    val translatedName: TranslateResponse?,
    @SerializedName("sap-sku")
    val sapSKU: String?,
) {
    val discountRate: String
        get() = saleText?.replace("OFF", "") ?: ""
}
