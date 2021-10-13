package com.kyawhut.codetest.utils.network

import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.reflect.KClass

/**
 * @author kyawhtut
 * @date 10/13/21
 */
object NetworkUtil {

    private const val WAIT_TIME = 60L
    private const val CONN_TIME = 60L

    fun <S : Any> createService(
        service: KClass<S>,
        baseURL: String,
        interceptors: List<Interceptor> = emptyList(),
        authenticators: List<Authenticator> = emptyList(),
    ): S {
        return provideRetrofit(
            provideOkHttpClient(interceptors, authenticators),
            baseURL
        ).create(service.java)
    }

    private fun provideRetrofit(
        okHttpClient: OkHttpClient,
        url: String,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(provideGson())
        .client(okHttpClient)
        .build()

    private fun provideOkHttpClient(
        interceptors: List<Interceptor> = emptyList(),
        authenticators: List<Authenticator> = emptyList()
    ): OkHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient()
        .callTimeout(WAIT_TIME, TimeUnit.SECONDS)
        .readTimeout(WAIT_TIME, TimeUnit.SECONDS)
        .connectTimeout(CONN_TIME, TimeUnit.SECONDS)
        .writeTimeout(WAIT_TIME, TimeUnit.SECONDS).apply {
            interceptors.forEach { addInterceptor(it) }
            authenticators.forEach { authenticator(it) }
        }.build()

    private fun provideGson(): GsonConverterFactory = GsonConverterFactory.create()

    class NetworkException(message: String) : Exception(message)
}
