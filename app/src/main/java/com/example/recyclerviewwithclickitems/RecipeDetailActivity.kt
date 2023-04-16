package com.example.recyclerviewwithclickitems

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipeDetailActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_recipe_details)

        val food = intent.getParcelableExtra<Food>("food")

        if(food !=null) {
            val recipeImage: ImageView = findViewById(R.id.recipeDetailsImage)
            val recipeText: TextView = findViewById(R.id.recipeDetailsText)

            recipeImage.setImageResource(food.image)
            recipeText.text = food.recipe
        }
    }
}