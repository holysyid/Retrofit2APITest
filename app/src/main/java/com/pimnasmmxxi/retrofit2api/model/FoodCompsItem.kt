package com.pimnasmmxxi.retrofit2api.model

import com.google.gson.annotations.SerializedName

data class FoodCompsItem(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("fcImages")
	val fcImages: String? = null,

	@field:SerializedName("_embedded")
	val embedded: Embedded? = null,

	@field:SerializedName("_links")
	val links: Links? = null,

	@field:SerializedName("fcFacts")
	val fcFacts: String? = null,

	@field:SerializedName("uuid")
	val uuid: String? = null,

	@field:SerializedName("fcName")
	val fcName: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)