package com.pimnasmmxxi.retrofit2api.model

import com.google.gson.annotations.SerializedName

data class Sharia(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("dsName")
	val dsName: String? = null,

	@field:SerializedName("_links")
	val links: Links? = null,

	@field:SerializedName("dsImages")
	val dsImages: String? = null,

	@field:SerializedName("dsFacts")
	val dsFacts: String? = null,

	@field:SerializedName("uuid")
	val uuid: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)