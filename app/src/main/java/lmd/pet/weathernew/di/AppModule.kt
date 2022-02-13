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
import lmd.pet.weathernew.utils.serialization.CitySerialization
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideGsonCity(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(CitySerialization::class.javaObjectType, CitySerialization())
            .create()
    }

    @Provides
    @Singleton
    fun providerOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .client(okHttpClient)
    }

    @Provides
    @Singleton
    fun provideWeatherApi(retrofit: Retrofit.Builder): WeatherApi {
        return retrofit
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.weatherUrl)
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCitiesApi(retrofit: Retrofit.Builder, gson: Gson): CitiesApi {
        return retrofit
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BuildConfig.citiesUrl)
            .build()
            .create(CitiesApi::class.java)
    }

}