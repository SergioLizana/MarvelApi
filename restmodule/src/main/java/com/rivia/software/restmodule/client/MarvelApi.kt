package com.rivia.software.restmodule.client

import com.rivia.software.restmodule.client.model.CharacterDataWrapper
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    @GET("v1/public/characters")
    fun getCharacters(
        @Query("ts") ts: String, @Query("apikey") apiKey: String,
        @Query("hash") hash: String, @Query("nameStartsWith") nameStartsWith: String?,
        @Query("offset") offset: Int, @Query("limit") limit: Int
    ): Deferred<Response<CharacterDataWrapper>>

    //    @GET("v1/public/characters/{characterId}")
    //    Call<CharacterDataWrapper> getCharacter(@Path("characterId") int characterId, @Query("ts") String ts,
    //                                            @Query("apikey") String apiKey, @Query("hash") String hash);
    //
    //
    //    @GET("v1/public/characters/{characterId}/comics")
    //    Call<ComicDataWrapper> getComics(@Path("characterId") int characterId, @Query("ts") String ts,
    //                                     @Query("apikey") String apiKey, @Query("hash") String hash,
    //                                     @Query("offset") int offset, @Query("limit") int limit);
    //
    //    @GET("/v1/public/comics/{comicId}")
    //    Call<ComicDataWrapper> getComic(@Path("comicId") int comicId, @Query("ts") String ts,
    //                                    @Query("apikey") String apiKey, @Query("hash") String hash);
    //
    //    @GET("/v1/public/comics/{comicId}/creators")
    //    Call<CreatorDataWrapper> getComicCreators(@Path("comicId") int comicId, @Query("ts") String ts,
    //                                              @Query("apikey") String apiKey, @Query("hash") String hash);
}
