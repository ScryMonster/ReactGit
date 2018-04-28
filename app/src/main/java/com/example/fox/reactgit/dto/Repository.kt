package com.example.fox.reactgit.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repository(@SerializedName("name") val name: String,
                      @SerializedName("full_name")   val fullName: String,
                      @SerializedName("description")  val description: String) : Parcelable


