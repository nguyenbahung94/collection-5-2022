package com.example.buildexample82022.coroutine

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlin.coroutines.CoroutineContext

class ExViewModel():ViewModel() {

    /*
    * example
    * viewModelScope.launch(myHandler) {
            voucherResult.postValue(
                safeApiCall {
                    ApiService.getInstance(getApplication()).checkValidVoucher(
                        voucherCode,
                        voucherRequest
                    )
                } ?: ResultWrapper.NoValue
            )
        }
    * */

    private val myHandler = object : CoroutineExceptionHandler {
        override val key: CoroutineContext.Key<*>
            get() = CoroutineExceptionHandler.Key

        override fun handleException(context: CoroutineContext, exception: Throwable) {
            Log.d("Log Error", "handleException: ${exception.message ?: "abc"}")
        }

    }
}