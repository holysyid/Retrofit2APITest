package com.pimnasmmxxi.retrofit2api.model

import com.google.gson.annotations.SerializedName

data class ResponseResult(

	@field:SerializedName("_links")
	val links: Links? = null,

	@field:SerializedName("_embedded")
	val embedded: Embedded? = null,

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_items")
	val totalItems: Int? = null,

	@field:SerializedName("page_count")
	val pageCount: Int? = null,

	@field:SerializedName("page_size")
	val pageSize: Int? = null
)