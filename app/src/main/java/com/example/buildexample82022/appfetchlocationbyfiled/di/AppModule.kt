package com.example.buildexample82022.appfetchlocationbyfiled.di

import android.content.Context
import com.example.buildexample82022.utils.StringUtils
import com.example.buildexample82022.utils.StringUtilsImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideStringUtils(@ApplicationContext context: Context): StringUtils =
        StringUtilsImpl(context)
}