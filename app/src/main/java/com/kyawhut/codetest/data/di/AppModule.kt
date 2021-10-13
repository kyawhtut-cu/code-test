package com.kyawhut.codetest.data.di

import com.kyawhut.codetest.BuildConfig
import com.kyawhut.codetest.data.network.API
import com.kyawhut.codetest.data.network.interceptor.ConnectionInterceptor
import com.kyawhut.codetest.data.network.interceptor.HeaderInterceptor
import com.kyawhut.codetest.utils.network.NetworkUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

/**
 * @author kyawhtut
 * @date 10/13/21
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        )
    }

    @Provides
    @Singleton
    fun provideAPI(
        connectionInterceptor: ConnectionInterceptor,
        loggingInterceptor: HttpLoggingInterceptor,
        headerInterceptor: HeaderInterceptor,
    ): API {
        return NetworkUtil.createService(
            API::class,
            BuildConfig.API_BASE_URL,
            listOf(headerInterceptor, connectionInterceptor, loggingInterceptor)
        )
    }

}
