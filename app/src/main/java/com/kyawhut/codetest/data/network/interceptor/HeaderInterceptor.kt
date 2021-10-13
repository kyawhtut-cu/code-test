package com.kyawhut.codetest.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * @author kyawhtut
 * @date 10/13/21
 */
class HeaderInterceptor @Inject constructor() : Interceptor {

    private val headerList = listOf(
        "X-OS-Name" to "android",
        "X-App-Platform" to "mobileapp_android",
        "X-Platform" to "mobile_app",
        "X-Site-Country" to "SG",
        "Accept-Language" to "en-SG",
    )

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder().apply {
                headerList.forEach {
                    addHeader(it.first, it.second)
                }
            }.build()
        )
    }
}
