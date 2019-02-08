package com.rivia.software.marvelapimvvm.repository.model

data class ErrorMessage(
        val code : Int? = 0,
        val message: String? = null,
        var exception: Throwable? = null)