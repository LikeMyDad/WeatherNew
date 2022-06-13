package lmd.pet.weathernew.core.base.coroutine

import kotlinx.coroutines.*
import java.util.concurrent.CancellationException

abstract class BaseCoroutineUseCase<out Result,in Params> {

    protected val mainScope: CoroutineScope by lazy { CoroutineScope(Dispatchers.Main) }
    private val asyncJob = SupervisorJob()

    var job: Job? = null
        set(value) {
            field?.let {
                if (it.isActive)
                    it.cancel()
            }
            field = value
        }

    protected abstract suspend fun doWork(params: Params?): Result

    protected suspend fun doAsync(params: Params?): Deferred<Result> = coroutineScope {
        async(asyncJob  + Dispatchers.IO) {
            doWork(params)
        }.also { job = it }
    }

    fun cancel(cause: CancellationException? = null): Boolean {
        return job?.let {
            it.cancel(cause)
            job = null
            true
        } ?: false
    }

}