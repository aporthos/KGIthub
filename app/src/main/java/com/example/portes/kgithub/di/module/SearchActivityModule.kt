package com.example.portes.kgithub.di.module

import com.example.portes.kgithub.io.services.SearchService
import com.example.portes.kgithub.parser.ParserSearch
import dagger.Module
import io.reactivex.disposables.CompositeDisposable
import dagger.Provides
import javax.inject.Singleton
import retrofit2.Retrofit
import javax.inject.Named


/**
 * Created by portes on 06/12/17.
 */
@Module(includes = arrayOf(NetModule::class))
class SearchActivityModule {
    @Singleton
    @Provides
    fun provideSearchService(@Named("Retrofit") retrofit: Retrofit): SearchService {
        return retrofit.create(SearchService::class.java)
    }

    @Singleton
    @Provides
    fun provideComposite(): CompositeDisposable {
        return CompositeDisposable()
    }
    @Singleton
    @Provides
    fun provideParser(): ParserSearch{
        return ParserSearch()
    }
}