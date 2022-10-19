package com.example.buildexample82022.appfetchlocationbyfiled.domain.usecase.contract

import com.example.buildexample82022.appfetchlocationbyfiled.api.model.Result
import com.example.buildexample82022.appfetchlocationbyfiled.common.ResultState
import kotlinx.coroutines.flow.Flow

interface GetVenuesUseCase {
    operator fun invoke(latitude: Double, longitude: Double): Flow<ResultState<List<Result>>>
}