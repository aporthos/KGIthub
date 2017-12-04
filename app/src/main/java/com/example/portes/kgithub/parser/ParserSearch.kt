package com.example.portes.kgithub.parser

import android.util.Log
import com.example.portes.kgithub.pojos.Item
import com.example.portes.kgithub.pojos.Owner

/**
 * Created by portes on 03/12/17.
 */

class ParserSearch {
    fun parserSearch(mArrayList: ArrayList<Item>):ArrayList<Item>{
        val mArrayListItem: ArrayList<Item> = ArrayList()
        for (item in mArrayList) {
            val mOwner = Owner(
                    item.owner.login,
                    item.owner.id,
                    item.owner.avatarUrl,
                    item.owner.gravatarId,
                    item.owner.url,
                    item.owner.htmlUrl,
                    item.owner.followersUrl,
                    item.owner.followingUrl,
                    item.owner.gistsUrl,
                    item.owner.starredUrl,
                    item.owner.subscriptionsUrl,
                    item.owner.organizationsUrl,
                    item.owner.reposUrl,
                    item.owner.eventsUrl,
                    item.owner.receivedEventsUrl,
                    item.owner.type,
                    item.owner.siteAdmin
                    )
            mArrayListItem.add(Item(item.id,
                    item.name,
                    item.fullName,
                    mOwner,
                    item.language,
                    item.watchers,
                    item.score))
        }

        return mArrayListItem
    }
}
