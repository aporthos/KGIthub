package com.example.portes.kgithub.di.component

import com.example.portes.kgithub.views.SearchActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.multibindings.IntoMap
import android.app.Activity
import dagger.android.AndroidInjector



/**
 * Created by portes on 06/12/17.
 */
@Module
abstract class ActivityBuilder {
    @Binds
    @IntoMap
    @ActivityKey(SearchActivity::class)
    abstract fun bindMainActivity(builder: SearchActivityComponent.Builder): AndroidInjector.Factory<out Activity>
}