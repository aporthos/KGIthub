package com.example.portes.kgithub.io.services

import com.example.portes.kgithub.pojos.Base
import com.example.portes.kgithub.pojos.Item
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by portes on 03/12/17.
 */
interface SearchService {

    @GET("/search/repositories")
    fun getRepositories(
            @Query("per_page") per_page: String,
            @Query("page") page: String,
            @Query("q") q: String): Observable<Base<ArrayList<Item>>>
}