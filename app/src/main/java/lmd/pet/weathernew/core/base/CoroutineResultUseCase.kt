package lmd.pet.weathernew.core.base

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class CoroutineResultUseCase<Result, Params> : BaseCoroutineUseCase<Result, Params>() {

    fun execute(
        scope: CoroutineScope = mainScope,
        params: Params? = null,
        onPreExecute: () -> Unit = {},
        onComplete: (Result) -> Unit = {},
        onError: (Throwable) -> Unit = {},
        onPostExecute: () -> Unit = {}
    ) = scope.launch {
        try {
            onPreExecute()

            val deferred = doAsync(params)
            onComplete(deferred.await())
        } catch (e: Throwable) {
            Log.getStackTraceString(e)
            onError(e)
            onPostExecute()
        }
    }

}