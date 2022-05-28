package lmd.pet.weathernew.di

import lmd.pet.weathernew.di.cities.citiesNetworkModule
import lmd.pet.weathernew.di.weather.weatherNetworkModule
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {

    fun provideInterceptor() =
        HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) }

    fun provideClient(interceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

    fun provideRetrofitBuilder(client: OkHttpClient) =
        Retrofit.Builder().client(client)

    single(named("Interceptor")) { provideInterceptor() }
    single { provideClient(get(named("Interceptor"))) }
    single(named("RetrofitBuilder")) { provideRetrofitBuilder(get()) }

    includes(networkModuleList)
}

private val networkModuleList = listOf(
    citiesNetworkModule,
    weatherNetworkModule
)