package com.rivia.software.restmodule.client.model

data class Series(
	val collectionURI: String? = null,
	val available: Int? = null,
	val returned: Int? = null,
	val items: List<Comic?>? = null
)
