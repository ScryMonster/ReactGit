package com.example.fox.reactgit.arch.domain.service

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by totskiy on 27.04.18.
 */
interface GitHubClient {

    @GET("organizations")
    fun getGithubOrganisations(
            @Query("")
    )
}