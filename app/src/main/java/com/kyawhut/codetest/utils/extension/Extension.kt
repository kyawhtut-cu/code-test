package com.kyawhut.codetest.utils.extension

import android.content.Context
import androidx.core.content.ContextCompat

/**
 * @author kyawhtut
 * @date 10/15/21
 */
object Extension {

    infix fun Context.getColor(resourceID: Int): Int {
        return ContextCompat.getColor(this, resourceID)
    }
}
