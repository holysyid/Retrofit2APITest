package com.pimnasmmxxi.retrofit2api.model

import com.google.gson.annotations.SerializedName

data class Group(

	@field:SerializedName("fgFacts")
	val fgFacts: String? = null,

	@field:SerializedName("fgImages")
	val fgImages: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("fgName")
	val fgName: String? = null,

	@field:SerializedName("_links")
	val links: Links? = null,

	@field:SerializedName("uuid")
	val uuid: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)