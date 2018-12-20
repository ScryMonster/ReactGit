package com.example.fox.reactgit.utils.ext

import android.content.Context
import android.util.DisplayMetrics
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.fox.reactgit.arch.ui.base.BasePresenter
import com.example.fox.reactgit.arch.ui.base.IBaseView
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Cody on 13.06.2018.
 */


infix fun Context.convertDpToPixel(dp: Float): Float {
    val metrics = resources.displayMetrics
    return (metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT).toFloat()
}



infix fun Any?.equalsObjects(obj:Any?)  = this == null && obj==null || this != null && this == obj


fun String.convertToDoubleWithDot():Double = try {
    this.trim().replace(",", ".").toDouble()
    }catch (e:Exception){
        0.0
    }




infix fun String.convertToTime(timePattern:String):String = try {
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault())
        formatter.timeZone = TimeZone.getTimeZone("UTC")
        val value = formatter.parse(this)

        val dateFormatter = SimpleDateFormat(timePattern, Locale.getDefault())
        dateFormatter.timeZone = TimeZone.getDefault()
        dateFormatter.format(value)

    } catch (e: Exception) {
        "00-00-0000 00:00"
    }

infix fun Date.getFormattedDate(timePattern:String) : String{
    val formatter = SimpleDateFormat(timePattern, Locale.getDefault())
    formatter.timeZone = TimeZone.getDefault()
    return formatter.format(this)
}

infix fun ImageView.loadUrl(url:String) = Glide.with(context).load(url).into(this)

fun <T:IBaseView,P:BasePresenter<T>> P.attachWithAction(view:T,action:P.()->Unit = {}){
    attach(view)
    init()
    action()
}







