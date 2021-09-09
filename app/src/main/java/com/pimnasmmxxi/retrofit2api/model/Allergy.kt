package com.pimnasmmxxi.retrofit2api.model

import com.google.gson.annotations.SerializedName

data class Allergy(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("daImages")
	val daImages: String? = null,

	@field:SerializedName("daSymptoms")
	val daSymptoms: String? = null,

	@field:SerializedName("_links")
	val links: Links? = null,

	@field:SerializedName("daFacts")
	val daFacts: String? = null,

	@field:SerializedName("daName")
	val daName: String? = null,

	@field:SerializedName("daTreatments")
	val daTreatments: String? = null,

	@field:SerializedName("uuid")
	val uuid: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)