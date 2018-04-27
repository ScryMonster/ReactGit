package com.example.fox.reactgit.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by totskiy on 27.04.18.
 */


infix fun ImageView.loadUrl(url:String) = Glide.with(context).load(url).into(this)