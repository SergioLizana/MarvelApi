package com.rivia.software.kotlinmvvmcoroutines.repository

import com.rivia.software.marvelapimvvm.repository.model.DataWrapper
import com.rivia.software.marvelapimvvm.repository.model.ErrorMessage
import com.rivia.software.restmodule.client.ApiWrapper
import com.rivia.software.restmodule.client.MarvelApi
import com.rivia.software.restmodule.client.model.Character


//TODO: Se podría hacer un repository generico para tener el codigo mas limpio y simplificado
class CharacterRepository(private val api: MarvelApi) {

    suspend fun getCharacters(
        nameStartsWith: String?,
        offset: Int, limit: Int
    ): DataWrapper<List<Character?>>? {

        val dataRequest = ApiWrapper.getCharacters(api, nameStartsWith, offset, limit)

       return try {
            val response = dataRequest?.await()


            if (response?.isSuccessful!!) {
                DataWrapper(response.body()?.data?.results)
            } else {
                DataWrapper(null, ErrorMessage(response.code(),response.errorBody().toString()))
            }
        } catch (e: Exception) {
            DataWrapper(null, ErrorMessage(null, null,e))
        }

    }

}