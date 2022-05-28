package lmd.pet.weathernew.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {
    single { provideInterceptor() }
    single { provideClient(get()) }
    single(named("RetrofitBuilder")) { provideRetrofitBuilder(get()) }
}

private fun provideInterceptor() =
    HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) }

private fun provideClient(interceptor: HttpLoggingInterceptor) =
    OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

private fun provideRetrofitBuilder(client: OkHttpClient) =
    Retrofit.Builder().client(client)

