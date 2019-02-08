package com.rivia.software.restmodule.client

import android.util.Log
import com.rivia.software.restmodule.client.model.CharacterDataWrapper
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import java.math.BigInteger
import java.security.MessageDigest

object ApiWrapper {

    fun getCharacters(api: MarvelApi?, nameStartsWith: String?, offset: Int, limit: Int): Deferred<Response<CharacterDataWrapper>>? {
        val timesStamp = System.currentTimeMillis()
        val apikey = "677166c25ed26a4e1b20993a1894761c"

        return api?.getCharacters(timesStamp.toString(),apikey,generateHash(timesStamp),nameStartsWith,offset,limit)

    }

    fun String.md5(): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }

    fun generateHash(timestamp: Long) : String = (timestamp.toString() + "cafa18e1f00bdda277ef9c55177f4e15f480fb38" + "677166c25ed26a4e1b20993a1894761c").md5().apply {
        Log.d("MD5 Hash", this)
    }

//    fun getCharacter(api: MarvelApi?, characterId: Int): Call<CharacterDataWrapper>? {
//        val timesStamp = System.currentTimeMillis()
//
//        return api?.getCharacter(
//                characterId,
//                timesStamp.toString(),
//                PUBLIC_KEY,
//                generateHash(timesStamp))
//    }
//
//    fun getComics(api: MarvelApi?, characterId: Int, offset: Int, limit: Int): Call<ComicDataWrapper>? {
//        val timesStamp = System.currentTimeMillis()
//
//        return api?.getComics(
//                characterId,
//                timesStamp.toString(),
//                PUBLIC_KEY,
//                generateHash(timesStamp),
//                offset,
//                limit)
//    }
//
//    fun getComic(api: MarvelApi?, comicId: Int): Call<ComicDataWrapper>? {
//        val timesStamp = System.currentTimeMillis()
//
//        return api?.getComic(
//                comicId,
//                timesStamp.toString(),
//                PUBLIC_KEY,
//                generateHash(timesStamp))
//    }
//
//    fun getComicCreators(api: MarvelApi?, comicId: Int): Call<CreatorDataWrapper>? {
//        val timesStamp = System.currentTimeMillis()
//
//        return api?.getComicCreators(
//                comicId,
//                timesStamp.toString(),
//                PUBLIC_KEY,
//                generateHash(timesStamp))
//    }
}