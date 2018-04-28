package com.example.fox.reactgit.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(@SerializedName("login") val login: String,
                @SerializedName("id")   val id: String,
                @SerializedName("avatar_url")  val avatarUrl: String,
                @SerializedName("url")  val url: String,
                @SerializedName("repos_url")  val reposUrl: String,
                @SerializedName("score")  val score: String) : Parcelable