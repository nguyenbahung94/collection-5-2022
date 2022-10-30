package com.example.buildexample82022.appfetchlocationbyfiled.api.model

data class Location(
    val address: String,
    val country: String,
    val locality: String,
    val neighbourhood: List<String>,
    val postcode: String,
    val region: String,
    val formatted_address: String
)
