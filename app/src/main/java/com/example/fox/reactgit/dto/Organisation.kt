package com.example.fox.reactgit.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Organisation(@SerializedName("login") private val login: String,
                        @SerializedName("id")  private val id: String,
                        @SerializedName("avatar_url") private val avatarUrl: String,
                        @SerializedName("url") private val url: String,
                        @SerializedName("repos_url") private val reposUrl: String,
                        @SerializedName("score") private val score: String) : Parcelable