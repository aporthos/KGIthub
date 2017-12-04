package com.example.portes.kgithub.presenter

import android.content.Context
import android.util.Log
import com.example.portes.kgithub.`interface`.InterPresSearch
import com.example.portes.kgithub.`interface`.InterViewSearch
import com.example.portes.kgithub.`interface`.OnSearchListener
import com.example.portes.kgithub.interactor.IntorSearch
import com.example.portes.kgithub.pojos.Item

/**
 * Created by portes on 03/12/17.
 */
class PresSearch(private val mViewSearch: InterViewSearch): InterPresSearch, OnSearchListener {
    val mInterIntorTask: IntorSearch = IntorSearch()
    companion object {
        val TAG = "PresSearch"
    }
    override fun presLoadRepositories(mPerPage: String, mPage: String, mQuery: String) {
        mInterIntorTask.intLoadRepositories(mPerPage, mPage, mQuery,this)
    }

    override fun onListSearch(mListSearch: ArrayList<Item>) {
        mViewSearch.vwListSearch(mListSearch)
    }
}