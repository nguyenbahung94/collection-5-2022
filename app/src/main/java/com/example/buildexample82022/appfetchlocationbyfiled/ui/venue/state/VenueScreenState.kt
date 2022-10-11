package com.example.buildexample82022.appfetchlocationbyfiled.ui.venue.state

data class VenueScreenState (
    val loading: Boolean = false,
    val allVenueList: List<com.example.buildexample82022.appfetchlocationbyfiled.api.model.Result> = emptyList(),
    val filteredList: List<com.example.buildexample82022.appfetchlocationbyfiled.api.model.Result> = emptyList(),
    val errorMessage: String? = null
)