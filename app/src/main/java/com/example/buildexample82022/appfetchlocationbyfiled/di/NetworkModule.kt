package com.example.buildexample82022.appfetchlocationbyfiled.di

import com.example.buildexample82022.BuildConfig
import com.example.buildexample82022.appfetchlocationbyfiled.api.VenuesService
import com.example.buildexample82022.appfetchlocationbyfiled.common.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitApi(okHttpClient: OkHttpClient): VenuesService = Retrofit.Builder()
        .baseUrl(BuildConfig.FOURSQUARE_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(VenuesService::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    // TODO Add your FourSquare API key here
                    .addHeader(Constants.AUTHORIZATION_KEY, "fsq30zgbD+FJdX3eeN71NqZs9Xj5ivyKAqJ6y828bLNl20Q=")
                    .build()
                chain.proceed(newRequest)
            }
            .build()
    }
}