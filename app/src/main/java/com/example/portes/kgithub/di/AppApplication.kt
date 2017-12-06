package com.example.portes.kgithub.di

import android.app.Activity
import android.app.Application
import com.example.portes.kgithub.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject
import dagger.android.DispatchingAndroidInjector



/**
 * Created by portes on 04/12/17.
 */
class AppApplication: Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)

    }
    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }
}