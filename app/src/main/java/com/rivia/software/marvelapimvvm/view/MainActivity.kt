package com.rivia.software.marvelapimvvm.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.rivia.software.kotlinmvvmcoroutines.repository.CharacterRepository
import com.rivia.software.marvelapimvvm.R
import com.rivia.software.marvelapimvvm.common.extensions.getViewModel
import com.rivia.software.marvelapimvvm.repository.model.DataWrapper
import com.rivia.software.marvelapimvvm.view.model.CharacterListResponse
import com.rivia.software.marvelapimvvm.view.viewmodel.ListViewModel
import com.rivia.software.restmodule.client.ApiClient
import com.rivia.software.restmodule.client.MarvelApi

class MainActivity : AppCompatActivity() {

    private val repository : CharacterRepository =
        CharacterRepository(ApiClient().createService(MarvelApi::class.java))

    val vm: ListViewModel by lazy {
        getViewModel { ListViewModel(repository) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm.getCharacterList()

        vm.characterList.observe(this, Observer<DataWrapper<List<CharacterListResponse>>> {
            Log.d("test", it.data?.get(0)?.description)
        })


    }
}
