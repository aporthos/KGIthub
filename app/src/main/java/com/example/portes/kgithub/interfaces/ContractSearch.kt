package com.example.portes.kgithub.interfaces

import com.example.portes.kgithub.pojos.Item

/**
 * Created by portes on 06/12/17.
 */
open interface ContractSearch {
    interface Presenter {
        fun presLoadRepositories(mPerPage: String, mPage: String, mQuery: String)
    }
    interface View {
        fun vwListSearch(mListSearch: ArrayList<Item>)
    }
    interface Interactor {
        fun intLoadRepositories(mPerPage: String, mPage: String, mQuery: String, mOnSearchListener: OnSearchListener)
        fun intDestroy()
    }
}