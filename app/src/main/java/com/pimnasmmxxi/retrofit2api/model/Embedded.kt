package com.pimnasmmxxi.retrofit2api.model

import com.google.gson.annotations.SerializedName

data class Embedded(

	@field:SerializedName("food_comps")
	val foodComps: List<FoodCompsItem?>? = null,

	@field:SerializedName("allergy")
	val allergy: Allergy? = null,

	@field:SerializedName("sharia")
	val sharia: Sharia? = null,

	@field:SerializedName("group")
	val group: Group? = null
)