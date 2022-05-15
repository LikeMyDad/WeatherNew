package lmd.pet.weathernew.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import lmd.pet.weathernew.BuildConfig
import lmd.pet.weathernew.data.api.CitiesApi
import lmd.pet.weathernew.data.api.WeatherApi
import lmd.pet.weathernew.utils.CitySerialization
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideGsonCity(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(CitySerialization::class.javaObjectType, CitySerialization())
            .create()
    }

    @Provides
    fun providerOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .client(okHttpClient)
    }

    @Provides
    fun provideWeatherApi(
        retrofit: Retrofit.Builder,
        @WeatherUrl url: String
    ): WeatherApi {
        return retrofit
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    fun provideCitiesApi(
        retrofit: Retrofit.Builder,
        gson: Gson,
        @CitiesUrl url: String
    ): CitiesApi {
        return retrofit
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(url)
            .build()
            .create(CitiesApi::class.java)
    }

    @WeatherUrl
    @Provides
    fun provideWeatherUrl() = BuildConfig.weatherUrl

    @CitiesUrl
    @Provides
    fun provideCitiesUrl() = BuildConfig.citiesUrl

    @Provides
    fun provideHttpLoggingInterceptor() =
        HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) }

}