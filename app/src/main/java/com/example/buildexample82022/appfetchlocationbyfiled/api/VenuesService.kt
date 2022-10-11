package com.example.buildexample82022.appfetchlocationbyfiled.api

import com.example.buildexample82022.appfetchlocationbyfiled.api.model.ResponseWrapper
import com.example.buildexample82022.appfetchlocationbyfiled.common.Constants
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface VenuesService {
    /**
     * Get venue recommendations.
     *
     * See [the docs](https://developer.foursquare.com/reference/places-nearby)
     */
    @GET("places/nearby?limit=${Constants.RESULT_LIMIT}")
    suspend fun getVenueRecommendations(@QueryMap query: Map<String, String>): ResponseWrapper
}
