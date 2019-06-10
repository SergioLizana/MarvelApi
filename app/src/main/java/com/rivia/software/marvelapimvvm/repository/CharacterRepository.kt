package com.rivia.software.kotlinmvvmcoroutines.repository

import com.rivia.software.marvelapimvvm.repository.model.DataWrapper
import com.rivia.software.marvelapimvvm.repository.model.ErrorMessage
import com.rivia.software.restmodule.client.ApiWrapper
import com.rivia.software.restmodule.client.MarvelApi
import com.rivia.software.restmodule.client.model.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response


//TODO: Se podría hacer un repository generico para tener el codigo mas limpio y simplificado
class CharacterRepository(private val api: MarvelApi) {

    fun getCharacters(
        nameStartsWith: String?,
        offset: Int,
        limit: Int,
        callback: (DataWrapper<List<Character?>>) -> Unit,
        error: (ErrorMessage) -> Unit
    ) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val dataRequest = ApiWrapper.getCharacters(api, nameStartsWith, offset, limit)
                if (dataRequest?.isSuccessful!!) {
                    callback(DataWrapper(dataRequest.body()?.data?.results))
                } else {
                    error(ErrorMessage(dataRequest.code(), dataRequest.errorBody().toString()))
                }

            } catch (e: java.lang.Exception) {
                kotlin.error(ErrorMessage(-1, "CRITICAL ERROR"))
            }
        }

    }


}