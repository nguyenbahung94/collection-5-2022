package com.example.buildexample82022.appfetchlocationbyfiled.domain.usecase.contract

import com.example.buildexample82022.appfetchlocationbyfiled.api.model.LatLong
import com.example.buildexample82022.appfetchlocationbyfiled.common.ResultState
import kotlinx.coroutines.flow.Flow

interface FetchLocationUseCase {
    operator fun invoke(): Flow<ResultState<LatLong>>
}