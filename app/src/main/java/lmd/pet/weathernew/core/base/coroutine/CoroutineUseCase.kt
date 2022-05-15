package lmd.pet.weathernew.core.base.coroutine

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class CoroutineUseCase<Params> : BaseCoroutineUseCase<Unit, Params>() {
    fun execute(
        scope: CoroutineScope = mainScope,
        params: Params? = null,
        onPreExecute: () -> Unit = {},
        onComplete: () -> Unit = {},
        onError: (Throwable) -> Unit = {},
        onPostExecute: () -> Unit = {}
    ) = scope.launch {
        try {
            onPreExecute()

            val deferred = doAsync(params)
            deferred.await()
            onComplete()
        } catch (e: Throwable) {
            Log.getStackTraceString(e)
            onError(e)
            onPostExecute()
        }
    }
}