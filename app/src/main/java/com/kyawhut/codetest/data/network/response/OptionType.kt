package com.kyawhut.codetest.data.network.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

/**
 * @author kyawhtut
 * @date 10/13/21
 */
@Keep
data class OptionType(
    @SerializedName("id")
    val id: String,
    @SerializedName("type")
    val type: String,
)
