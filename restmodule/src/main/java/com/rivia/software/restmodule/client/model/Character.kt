package com.rivia.software.restmodule.client.model

data class Character(
	val thumbnail: Thumbnail? = null,
	val urls: List<Url?>? = null,
	val stories: Stories? = null,
	val series: Series? = null,
	val comics: ComicList? = null,
	val name: String? = null,
	val description: String? = null,
	val modified: String? = null,
	val id: Int? = null,
	val resourceURI: String? = null,
	val events: Events? = null
)
