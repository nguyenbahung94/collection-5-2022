package com.example.buildexample82022.appfetchlocationbyfiled.api.model

data class GeoCode(
    val main: Main
)

data class Main(
    val latitude: Double,
    val longitude: Double,
)