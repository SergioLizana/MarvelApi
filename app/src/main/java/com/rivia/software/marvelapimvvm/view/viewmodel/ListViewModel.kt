package com.rivia.software.marvelapimvvm.view.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rivia.software.kotlinmvvmcoroutines.repository.CharacterRepository
import com.rivia.software.marvelapimvvm.repository.model.DataWrapper
import com.rivia.software.marvelapimvvm.view.model.CharacterListResponse
import com.rivia.software.restmodule.client.model.CharacterDataWrapper
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class ListViewModel(private val repository: CharacterRepository) : ViewModel(){

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)


    val characterList = MutableLiveData<DataWrapper<List<CharacterListResponse>>>()

    fun getCharacterList(){
          repository.getCharacters("",0,99,{ list ->
              characterList.postValue(DataWrapper(list?.data?.map {
                  CharacterListResponse(
                      it?.id,
                      it?.name,
                      it?.description,
                      it?.modified,
                      it?.thumbnail?.path)
              }))
            },{
              //TODO: Error
            })
    }

    fun cancelAllRequests() = coroutineContext.cancel()

}