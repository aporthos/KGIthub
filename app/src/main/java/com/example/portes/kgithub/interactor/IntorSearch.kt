package com.example.portes.kgithub.interactor

import android.util.Log
import com.example.portes.kgithub.`interface`.InterIntorSearch
import com.example.portes.kgithub.`interface`.OnSearchListener
import com.example.portes.kgithub.io.RetrofitService
import com.example.portes.kgithub.io.services.Search
import com.example.portes.kgithub.parser.ParserSearch
import com.example.portes.kgithub.pojos.Item
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


/**
 * Created by portes on 03/12/17.
 */
class IntorSearch : RetrofitService(), InterIntorSearch {
    companion object {
        val TAG = "IntorSearch"
    }
    val mComposite: CompositeDisposable = CompositeDisposable()
    val mParserSearch: ParserSearch = ParserSearch()

    open override fun intLoadRepositories( mPerPage: String, mPage: String, mQuery: String , mOnSearchListener: OnSearchListener) {
        val mDisposable:Disposable = getRetrofit().create(Search::class.java).getRepositories(mPerPage, mPage, mQuery)
                .subscribeOn(Schedulers.computation())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe {
                     var mArrayListSearch: ArrayList<Item> = mParserSearch.parserSearch(it.items)
                     mOnSearchListener.onListSearch(mArrayListSearch)
                 }
        mComposite.add(mDisposable)
    }


}