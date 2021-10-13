package com.kyawhut.codetest.data.network.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

/**
 * @author kyawhtut
 * @date 10/13/21
 */
@Keep
data class RelationshipsResponse(
    @SerializedName("option-type")
    val optionType: OptionType,
    @SerializedName("ads")
    val adsList: Map<String, List<Any>>?,
    @SerializedName("ingredient-preference")
    val ingredientPreference: IngredientPreferenceResponse?,
    @SerializedName("filter-values")
    val filterValues: FilterValueResponse?,
    @SerializedName("product")
    val product: Product?,
)
