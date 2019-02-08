package com.rivia.software.restmodule.client.model

data class CharacterDataContainer(
	val total: Int? = null,
	val offset: Int? = null,
	val limit: Int? = null,
	val count: Int? = null,
	val results: List<Character?>? = null
)
