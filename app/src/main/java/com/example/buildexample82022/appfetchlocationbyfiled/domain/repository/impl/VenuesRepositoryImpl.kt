package com.example.buildexample82022.appfetchlocationbyfiled.domain.repository.impl

import com.example.buildexample82022.appfetchlocationbyfiled.api.VenueRecommendationsQueryBuilder
import com.example.buildexample82022.appfetchlocationbyfiled.api.VenuesService
import com.example.buildexample82022.appfetchlocationbyfiled.api.model.Result
import com.example.buildexample82022.appfetchlocationbyfiled.domain.repository.contract.VenueRepository
import javax.inject.Inject

class VenuesRepositoryImpl @Inject constructor(
    private val venuesService: VenuesService
) : VenueRepository {
    /**
     * This functions returns the list of venues from Api Result
     *   @param latitude Latitude of user's current location
     *   @param longitude Longitude of user's current location
     * @return List<Result> return list of venues
     */

    override suspend fun fetchVenues(latitude: Double, longitude: Double): List<Result> {
        val query = VenueRecommendationsQueryBuilder()
            .setLatitudeLongitude(latitude, longitude)
            .build()
        return venuesService.getVenueRecommendations(query).results
    }

}