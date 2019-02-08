package com.rivia.software.marvelapimvvm.repository.model

data class DataWrapper<T>(
    var data: T? = null,
    var errorMsg: ErrorMessage? = null)