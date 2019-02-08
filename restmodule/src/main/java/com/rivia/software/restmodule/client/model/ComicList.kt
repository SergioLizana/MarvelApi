package com.rivia.software.restmodule.client.model

data class ComicList(
	val collectionURI: String? = null,
	val available: Int? = null,
	val returned: Int? = null,
	val items: List<Comic?>? = null
)
