package com.example.portes.kgithub.interactor

import android.util.Log
import com.example.portes.kgithub.interfaces.ContractSearch
import com.example.portes.kgithub.interfaces.OnSearchListener
import com.example.portes.kgithub.io.services.SearchService
import com.example.portes.kgithub.parser.ParserSearch
import com.example.portes.kgithub.pojos.Item
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by portes on 03/12/17.
 */
class IntorSearch
    @Inject constructor(private val mSearchService: SearchService,
                        private val mCompositeDisposable: CompositeDisposable,
                        private val mParserSearch: ParserSearch): ContractSearch.Interactor {
    companion object {
        val TAG = "IntorSearch"
    }

    open override fun intLoadRepositories(mPerPage: String, mPage: String, mQuery: String,
                                          mOnSearchListener: OnSearchListener) {
        val mDisposable: Disposable = mSearchService.getRepositories(mPerPage, mPage, mQuery)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {
                    Log.i(TAG, "intLoadRepositories: ${it.items.size}")
                    var mArrayListSearch: ArrayList<Item> = mParserSearch.parserSearch(it.items)
                    mOnSearchListener.onListSearch(mArrayListSearch)
                }, Consumer {
                    Log.i(TAG, "intLoadRepositories: ${it.localizedMessage}")
                })
        mCompositeDisposable.add(mDisposable)
    }
    override fun intDestroy() {
        mCompositeDisposable.clear()
    }
}