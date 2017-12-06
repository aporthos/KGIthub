package com.example.portes.kgithub.di.module

import android.app.Application
import com.example.portes.kgithub.utils.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import javax.inject.Singleton
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.IOException
import java.net.URLEncoder
import retrofit2.converter.gson.GsonConverterFactory
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import javax.inject.Named


/**
 * Created by portes on 06/12/17.
 */
@Module
class NetModule {
    @Provides
    @Singleton
    fun provideUrl(): String {
        return  BASE_URL
    }
    @Provides
    @Singleton
    fun provideOkHttpCache(application: Application): Cache {
        val cacheSize:Long = 10 * 1024 * 1024 // 10 MiB
        return Cache(application.getCacheDir(), cacheSize)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Named("Retrofit")
    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, url: String): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}