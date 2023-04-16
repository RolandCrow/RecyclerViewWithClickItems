package com.example.recyclerviewwithclickitems

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var foodList: ArrayList<Food>
    lateinit var foodAdapter: FoodAdapter
    lateinit var foodRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foodList.add(Food("Biryani",R.drawable.biryani, getString(R.string.recipe_biryani)) )
        foodList.add(Food("Beef Bourguignon",R.drawable.boeuf_bourguignon, getString(R.string.recipe_boeuf_bourguignon)) )
        foodList.add(Food("Pho",R.drawable.pho, getString(R.string.recipe_pho)) )
        foodList.add(Food("Clam Chowder",R.drawable.clam_chowder, getString(R.string.recipe_clam_chowder)) )
        foodList.add(Food("Poutine",R.drawable.poutine, getString(R.string.recipe_poutine)) )
        foodList.add(Food("Peking Duck",R.drawable.peking_duck, getString(R.string.recipe_peking_duck)) )
        foodList.add(Food("Tacos",R.drawable.tacos, getString(R.string.recipe_tacos)) )
        foodList.add(Food("Shakshuka",R.drawable.shakshuka, getString(R.string.recipe_shakshuka)) )

        foodAdapter = FoodAdapter(foodList)
        foodRecyclerView = findViewById(R.id.foods_recycler_view)
        foodRecyclerView.layoutManager = LinearLayoutManager(this)
        foodRecyclerView.adapter = foodAdapter

        foodAdapter.onFoodClicked = {
            val intent = Intent(this, RecipeDetailActivity::class.java)
            intent.putExtra("food", it)
            startActivity(intent)

        }


    }
}