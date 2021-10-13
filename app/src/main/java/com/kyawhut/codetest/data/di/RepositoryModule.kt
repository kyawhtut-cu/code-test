package com.kyawhut.codetest.data.di

import com.kyawhut.codetest.ui.sale.SaleRepository
import com.kyawhut.codetest.ui.sale.SaleRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author kyawhtut
 * @date 10/13/21
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSaleRepo(repo: SaleRepositoryImpl): SaleRepository = repo
}
