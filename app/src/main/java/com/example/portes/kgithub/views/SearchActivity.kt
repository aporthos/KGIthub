package com.example.portes.kgithub.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.portes.kgithub.R
import com.example.portes.kgithub.`interface`.InterPresSearch
import com.example.portes.kgithub.`interface`.InterViewSearch
import com.example.portes.kgithub.pojos.Item
import com.example.portes.kgithub.presenter.PresSearch
import com.example.portes.kgithub.views.adapter.SearchAdapter

import kotlinx.android.synthetic.main.activity_main.*

class SearchActivity : BaseActivity(), InterViewSearch {
    private val mPresMain: PresSearch by lazy {
        PresSearch(this)
    }
    lateinit var mAdapterSearch: SearchAdapter
    companion object {
        val TAG = "SearchActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initView()
        mPresMain.presLoadRepositories("10","1","android")
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

