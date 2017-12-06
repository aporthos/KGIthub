package com.example.portes.kgithub.presenter

import android.util.Log
import com.example.portes.kgithub.interfaces.OnSearchListener
import com.example.portes.kgithub.interfaces.ContractSearch
import com.example.portes.kgithub.pojos.Item
import javax.inject.Inject


/**
 * Created by portes on 03/12/17.
 */
class PresSearch @Inject constructor(private val mViewSearch: ContractSearch.View, private val mInterIntorTask: ContractSearch.Interactor): ContractSearch.Presenter, OnSearchListener {
    companion object {
        val TAG = "PresSearch"
    }
    //val mInterIntorTask: IntorSearch = IntorSearch()

    override fun presLoadRepositories(mPerPage: String, mPage: String, mQuery: String) {
        Log.i(TAG, "presLoadRepositories: ${mInterIntorTask}")
        mInterIntorTask.intLoadRepositories(mPerPage, mPage, mQuery,this)
    }

    override fun onListSearch(mListSearch: ArrayList<Item>) {
        mViewSearch.vwListSearch(mListSearch)
    }
}