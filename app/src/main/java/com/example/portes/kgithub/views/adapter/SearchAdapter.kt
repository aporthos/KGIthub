package com.example.portes.kgithub.views.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.example.portes.kgithub.R
import com.example.portes.kgithub.pojos.Item
import com.example.portes.kgithub.utils.inflate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_search.view.*
import javax.security.auth.login.LoginException

/**
 * Created by portes on 03/12/17.
 */
class SearchAdapter(val mSearchArrayList: ArrayList<Item>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        val TAG = "SearchAdapter"
        val ITEM: Int = 1
        val FOOTER : Int = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var mViewHolder: RecyclerView.ViewHolder
        when (viewType) {
            ITEM -> mViewHolder = getHolderItem(parent)
            FOOTER -> mViewHolder = getHolderFooter(parent)
            else -> {
                mViewHolder = getHolderItem(parent)
            }
        }
        return mViewHolder
    }

    fun getHolderItem(parent: ViewGroup): ItemViewHolder {
        val mView: View = parent.inflate(R.layout.item_search)
        return ItemViewHolder(mView)
    }

    fun getHolderFooter(parent: ViewGroup): FooterViewHolder {
        val mView: View = parent.inflate(R.layout.item_search)
        return FooterViewHolder(mView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            Log.i(TAG, "onBindViewHolder: $ItemViewHolder")
            val mItem: Item = mSearchArrayList[position]
            holder.bind(mItem)
        } else {
            Log.i(TAG, "onBindViewHolder: FooterViewHolder")
        }
    }
    override fun getItemCount(): Int = mSearchArrayList.size

    override fun getItemViewType(position: Int): Int {
        if (position == mSearchArrayList.size - 1) {
            return FOOTER
        }
        return ITEM
    }

    open fun loadItems(mSearchArrayList: ArrayList<Item>){
        this.mSearchArrayList.addAll(mSearchArrayList)
        notifyDataSetChanged()
    }

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        companion object {
            val TAG = "ViewHolder"
        }
        fun bind(mItem: Item) = with(itemView) {
            val mLanguaje  = mItem.language?: "S/L"
            lblFullName.text = mItem.fullName
            lblLanguaje.text = "Lang: $mLanguaje"
            lblWatchers.text = "Watchers: ${mItem.watchers}"
            lblScore.text = "Score: ${mItem.score}"
            Picasso.with(context).load(mItem.owner.avatarUrl).into(imgAvatar)
        }
    }
    class FooterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        companion object {
            val TAG = "Footer"
        }


    }

}