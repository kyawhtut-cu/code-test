package com.kyawhut.codetest.data.network.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

/**
 * @author kyawhtut
 * @date 10/13/21
 */
@Keep
data class FilterValueResponse(
    @SerializedName("data")
    val data: List<OptionType>,
)
