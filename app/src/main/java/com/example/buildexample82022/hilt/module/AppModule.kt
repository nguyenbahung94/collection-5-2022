package com.example.buildexample82022.hilt.module

import com.example.buildexample82022.hilt.repository.CryptocurrencyRepository
import com.example.buildexample82022.hilt.repository.CryptocurrencyRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideCryptocurrencyRepository(): CryptocurrencyRepository = CryptocurrencyRepositoryImpl()
}