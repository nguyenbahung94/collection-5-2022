package com.example.buildexample82022.appfetchlocationbyfiled.domain.repository.contract

interface VenueRepository {
    suspend fun fetchVenues(latitude: Double, longitude: Double):List<com.example.buildexample82022.appfetchlocationbyfiled.api.model.Result>
}