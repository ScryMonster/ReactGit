package com.example.fox.reactgit.dto

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "users")
data class User(@SerializedName("login") val login: String,
                @SerializedName("id")
                @PrimaryKey
                val id: String,
                @SerializedName("avatar_url")  val avatarUrl: String,
                @SerializedName("url")  val url: String,
                @SerializedName("repos_url")  val reposUrl: String,
                @SerializedName("score")  val score: String,
                var saved:Boolean = false) : Parcelable