package com.example.buildexample82022.appfetchlocationbyfiled.domain.usecase.impl

import android.Manifest
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.annotation.RequiresPermission
import androidx.core.location.component1
import androidx.core.location.component2
import com.example.buildexample82022.R
import com.example.buildexample82022.appfetchlocationbyfiled.api.model.LatLong
import com.example.buildexample82022.appfetchlocationbyfiled.common.ResultState
import com.example.buildexample82022.appfetchlocationbyfiled.di.IoDispatcher
import com.example.buildexample82022.appfetchlocationbyfiled.domain.usecase.contract.FetchLocationUseCase
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationToken
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.OnTokenCanceledListener
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchLocationUseCaseImpl @Inject constructor(
    private val context: Context,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
):FetchLocationUseCase {


    /**
     * This functions returns the response coming from the API
     *  @Emits Flow<ResultState<LatLong>> Emits state like Loading, Error and Success for LatLong
     */

    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    override fun invoke(): Flow<ResultState<LatLong>> {
        return callbackFlow {
            trySend(ResultState.Loading)
            val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
            fusedLocationClient.getCurrentLocation(
                Priority.PRIORITY_BALANCED_POWER_ACCURACY,
                object : CancellationToken() {
                    override fun onCanceledRequested(p0: OnTokenCanceledListener) =
                        CancellationTokenSource().token

                    override fun isCancellationRequested() = false
                }).addOnSuccessListener { location ->
                if (location != null) {
                    val (latitude, longitude) = location
                    // Send the new location to the Flow observers
                    trySend(ResultState.Success(LatLong(latitude, longitude)))
                } else {
                    // Send Failure to the Flow observers
                    trySend(ResultState.Failure(context.getString(R.string.not_able_fetch_str)))
                }
            }.addOnFailureListener {
                Log.d(TAG, it.message ?: "")
                // Send Failure to the Flow observers
                trySend(ResultState.Failure(context.getString(R.string.not_able_fetch_str)))
            }.addOnCanceledListener {
                Log.d(TAG, context.getString(R.string.location_fetch_cancelled))
                // Send Failure to the Flow observers
                trySend(ResultState.Failure(context.getString(R.string.location_fetch_cancelled)))
            }
            awaitClose {
                Log.d(TAG, "Stopped observing location update")
            }
        }.flowOn(ioDispatcher)
    }
}