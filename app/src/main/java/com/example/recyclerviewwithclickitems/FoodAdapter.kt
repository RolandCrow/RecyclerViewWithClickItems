package com.example.recyclerviewwithclickitems

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(val foodList: ArrayList<Food>): RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    var onFoodClicked: ((food: Food)-> Unit)? = null

    inner class FoodViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val foodImageView: ImageView = itemView.findViewById(R.id.item_image)
        val titleTextView: TextView = itemView.findViewById(R.id.item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false )
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.foodImageView.setImageResource(food.image)
        holder.titleTextView.text = food.name

        holder.itemView.setOnClickListener {
            onFoodClicked?.invoke(food)
        }
    }


}