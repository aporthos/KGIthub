package com.example.portes.kgithub.di.module

import dagger.Binds
import dagger.Module
import com.example.portes.kgithub.interfaces.ContractSearch
import com.example.portes.kgithub.interactor.IntorSearch
import com.example.portes.kgithub.presenter.PresSearch
import com.example.portes.kgithub.views.SearchActivity


/**
 * Created by portes on 06/12/17.
 */
@Module
abstract class InterfacesSearchModule {
    @Binds
    abstract fun provideSearchPresenter(presSearch: PresSearch): ContractSearch.Presenter
    @Binds
    abstract fun provideSearchView(searchActivity: SearchActivity): ContractSearch.View
    @Binds
    abstract fun provideSearchInteractor(interactor: IntorSearch): ContractSearch.Interactor
}