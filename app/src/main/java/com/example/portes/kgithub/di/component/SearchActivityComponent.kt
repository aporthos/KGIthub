package com.example.portes.kgithub.di.component

import com.example.portes.kgithub.di.module.InterfacesSearchModule
import com.example.portes.kgithub.di.module.NetModule
import com.example.portes.kgithub.di.module.SearchActivityModule
import com.example.portes.kgithub.views.SearchActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by portes on 06/12/17.
 */
@Singleton
@Subcomponent(modules = arrayOf(
        SearchActivityModule::class,
        NetModule::class,
        InterfacesSearchModule::class
    ))
interface SearchActivityComponent: AndroidInjector<SearchActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SearchActivity>()
}