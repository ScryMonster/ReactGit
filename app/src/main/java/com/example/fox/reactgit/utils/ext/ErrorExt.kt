package com.example.fox.reactgit.utils.ext

import org.json.JSONObject
import retrofit2.HttpException

fun Throwable.tryToParseHttpError(): String? {
    return try {
        JSONObject((this as? HttpException)?.response()?.errorBody()?.string()).getString("message")
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}


fun tryCode(error:(Exception) ->Unit = {it.message!! errorLog "Error"},code:() -> Unit){
    try {
        code()
    }catch (e:Exception){
        error(e)
    }
}
