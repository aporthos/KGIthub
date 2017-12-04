package com.example.portes.kgithub.pojos

import com.google.gson.annotations.SerializedName

/**
 * Created by portes on 03/12/17.
 */
data class Owner(
        @SerializedName("login") val login: String, //hmkcode
        @SerializedName("id") val id: Int, //3790597
        @SerializedName("avatar_url") val avatarUrl: String, //https://avatars3.githubusercontent.com/u/3790597?v=4
        @SerializedName("gravatar_id") val gravatarId: String,
        @SerializedName("url") val url: String, //https://api.github.com/users/hmkcode
        @SerializedName("html_url") val htmlUrl: String, //https://github.com/hmkcode
        @SerializedName("followers_url") val followersUrl: String, //https://api.github.com/users/hmkcode/followers
        @SerializedName("following_url") val followingUrl: String, //https://api.github.com/users/hmkcode/following{/other_user}
        @SerializedName("gists_url") val gistsUrl: String, //https://api.github.com/users/hmkcode/gists{/gist_id}
        @SerializedName("starred_url") val starredUrl: String, //https://api.github.com/users/hmkcode/starred{/owner}{/repo}
        @SerializedName("subscriptions_url") val subscriptionsUrl: String, //https://api.github.com/users/hmkcode/subscriptions
        @SerializedName("organizations_url") val organizationsUrl: String, //https://api.github.com/users/hmkcode/orgs
        @SerializedName("repos_url") val reposUrl: String, //https://api.github.com/users/hmkcode/repos
        @SerializedName("events_url") val eventsUrl: String, //https://api.github.com/users/hmkcode/events{/privacy}
        @SerializedName("received_events_url") val receivedEventsUrl: String, //https://api.github.com/users/hmkcode/received_events
        @SerializedName("type") val type: String, //User
        @SerializedName("site_admin") val siteAdmin: Boolean //false
)