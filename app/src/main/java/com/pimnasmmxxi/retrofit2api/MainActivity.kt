package com.pimnasmmxxi.retrofit2api

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import com.pimnasmmxxi.retrofit2api.databinding.ActivityMainBinding
import com.pimnasmmxxi.retrofit2api.service.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var itemsArray: ArrayList<Cell> = ArrayList()
    lateinit var adapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.jsonResultsTextview.text = ""
        setupRecyclerView()
        parseJSON()
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.jsonResultsRecyclerview.layoutManager = layoutManager
        binding.jsonResultsRecyclerview.setHasFixedSize(true)
        val dividerItemDecoration =
            DividerItemDecoration(binding.jsonResultsRecyclerview.context, layoutManager.orientation)
        ContextCompat.getDrawable(this, R.drawable.line_divider)
            ?.let { drawable -> dividerItemDecoration.setDrawable(drawable) }
        binding.jsonResultsRecyclerview.addItemDecoration(dividerItemDecoration)
    }


    private fun parseJSON() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.pastiin.app")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(APIService::class.java)

        CoroutineScope(Dispatchers.IO).launch {

            // Do the GET request and get response
            val response = service.getDataNested()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    // Convert raw JSON to pretty JSON using GSON library
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = gson.toJson(response.body())

                    Log.d("Pretty Printed JSON :", prettyJson)
                    binding.jsonResultsTextview.text = prettyJson

                    val items = response.body()?.embedded?.foodComps
                    if (items != null) {
                        for (i in 0 until items.count()) {
                            // Name
                            val name = items[i]?.fcName ?: "N/A"
                            Log.d("Name: ", name)

                            // fact
                            val fact = items[i]?.fcFacts ?: "N/A"
                            Log.d("Fact: ", fact)

                            // image link
                            val link = items[i]?.fcImages ?: "N/A"
                            Log.d("Link: ", link)

                            // allergyof
                            val AllergyOf = items[i]?.embedded?.allergy?.daName ?: "N/A"
                            Log.d("allergy of : ", AllergyOf)

                            // groupof
                            val GroupOf = items[i]?.embedded?.group?.fgName ?: "N/A"
                            Log.d("groupof of : ", GroupOf)

                            val model =
                                Cell(
                                    name,
                                    fact,
                                    link,
                                    AllergyOf,
                                    GroupOf
                                )
                            itemsArray.add(model)

                            adapter = RVAdapter(itemsArray)
                            adapter.notifyDataSetChanged()
                        }
                    }

                    binding.jsonResultsRecyclerview.adapter = adapter

                } else {

                    Log.e("RETROFIT_ERROR", response.code().toString())

                }
            }
        }
    }
}