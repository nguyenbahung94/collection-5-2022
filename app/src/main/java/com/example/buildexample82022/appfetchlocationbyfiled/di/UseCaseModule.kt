package com.example.buildexample82022.appfetchlocationbyfiled.di

import android.content.Context
import com.example.buildexample82022.appfetchlocationbyfiled.domain.repository.contract.VenueRepository
import com.example.buildexample82022.appfetchlocationbyfiled.domain.usecase.contract.FetchLocationUseCase
import com.example.buildexample82022.appfetchlocationbyfiled.domain.usecase.contract.GetVenuesUseCase
import com.example.buildexample82022.appfetchlocationbyfiled.domain.usecase.impl.FetchLocationUseCaseImpl
import com.example.buildexample82022.appfetchlocationbyfiled.domain.usecase.impl.GetVenuesUseCaseImpl
import com.example.buildexample82022.utils.StringUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun gerVenuesUseCase(
        venueRepository: VenueRepository,
        stringUtils: StringUtils,
        @IoDispatcher coroutineDispatcher: CoroutineDispatcher
    ): GetVenuesUseCase = GetVenuesUseCaseImpl(
        venueRepository, stringUtils, coroutineDispatcher
    )

    @Provides
    fun getFetchLocationUseCase(
        @ApplicationContext context: Context,
        @IoDispatcher coroutineDispatcher: CoroutineDispatcher
    ): FetchLocationUseCase = FetchLocationUseCaseImpl(
        context, coroutineDispatcher
    )

}