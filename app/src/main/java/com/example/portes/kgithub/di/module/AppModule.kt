package com.example.portes.kgithub.di.module

import android.content.Context
import com.example.portes.kgithub.di.AppApplication
import com.example.portes.kgithub.di.component.SearchActivityComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by portes on 06/12/17.
 */
@Module(subcomponents= arrayOf(SearchActivityComponent::class))
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: AppApplication): Context {
        return application
    }
}