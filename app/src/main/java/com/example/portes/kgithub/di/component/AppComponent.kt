package com.example.portes.kgithub.di.component

import android.app.Application
import com.example.portes.kgithub.di.AppApplication
import com.example.portes.kgithub.di.module.AppModule
import com.example.portes.kgithub.di.module.NetModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule


/**
 * Created by portes on 05/12/17.
 */
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        NetModule::class,
        ActivityBuilder::class
        ))
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
    fun inject(app: AppApplication)
}