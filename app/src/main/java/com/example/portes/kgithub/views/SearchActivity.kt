package com.example.portes.kgithub.views

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.portes.kgithub.R
import com.example.portes.kgithub.interfaces.ContractSearch
import com.example.portes.kgithub.pojos.Item
import com.example.portes.kgithub.views.adapter.SearchAdapter
import dagger.android.AndroidInjection

import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class SearchActivity : BaseActivity(), ContractSearch.View {

    lateinit var mAdapterSearch: SearchAdapter
    companion object {
        val TAG = "SearchActivity"
    }
    @Inject
    lateinit var mSearchPresenter: ContractSearch.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initView()
        Log.i(TAG, "onCreate: ${mSearchPresenter}")
        mSearchPresenter.presLoadRepositories("10","1","android")
    }
    override fun initView() {
        mAdapterSearch = SearchAdapter(ArrayList<Item>())
        rViewRepos.setHasFixedSize(true)
        rViewRepos.layoutManager = LinearLayoutManager(this)
        rViewRepos.adapter = mAdapterSearch
    }

    override fun vwListSearch(mListSearch: ArrayList<Item>) {
        mAdapterSearch.loadItems(mListSearch)
    }
    //<editor-fold desc="MENU">
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    //</editor-fold>
}

