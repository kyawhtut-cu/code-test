package com.kyawhut.codetest.data.network.request

/**
 * @author kyawhtut
 * @date 10/15/21
 */
data class ProductRequest private constructor(
    val page: Int,
    val perPage: Int,
    val include: String,
    val filterPage: String,
    val includeOption: String,
    val sort: String,
) {
    class Builder {
        var page: Int = 1
        var perPage: Int = 30
        var include: String = "featured_variant,featured_ad"
        var filterPage: String = "sale"
        var includeOption: String = "brand,option_types.option_values,featured_variant,featured_ad"
        var sort: String = "sales"

        fun build(): ProductRequest = ProductRequest(
            page,
            perPage,
            include,
            filterPage,
            includeOption,
            sort
        )
    }
}

fun productRequest(block: ProductRequest.Builder.() -> Unit): ProductRequest {
    return ProductRequest.Builder().also(block).build()
}
