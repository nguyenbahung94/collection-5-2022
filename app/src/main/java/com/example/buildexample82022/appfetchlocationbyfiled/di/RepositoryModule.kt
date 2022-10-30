package com.example.buildexample82022.appfetchlocationbyfiled.di

import com.example.buildexample82022.appfetchlocationbyfiled.api.VenuesService
import com.example.buildexample82022.appfetchlocationbyfiled.domain.repository.contract.VenueRepository
import com.example.buildexample82022.appfetchlocationbyfiled.domain.repository.impl.VenuesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideVenueRepository(
        VenuesService: VenuesService
    ):VenueRepository = VenuesRepositoryImpl(VenuesService)
}