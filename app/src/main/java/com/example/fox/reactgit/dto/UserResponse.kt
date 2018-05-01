package com.example.fox.reactgit.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class UserResponse(
        @SerializedName("total_count")  val totalCount:Int,
        @SerializedName("incomplete_results") val incompleteResults:Boolean,
        @SerializedName("items")val items:List<User>) : Parcelable