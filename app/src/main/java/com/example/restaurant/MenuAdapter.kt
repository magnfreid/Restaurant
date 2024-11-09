package com.example.restaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView

class MenuAdapter(private val menu: List<MenuItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class FoodItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: MaterialTextView = itemView.findViewById(R.id.tv_menu_item_name)
        val tvDescription: MaterialTextView = itemView.findViewById(R.id.tv_menu_item_description)
        val tvPrice: MaterialTextView = itemView.findViewById(R.id.tv_menu_item_price)
        val ivImage: ImageView = itemView.findViewById(R.id.iv_menu_item_image)
    }

    inner class TitleItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMenuTitle: MaterialTextView = itemView.findViewById(R.id.tv_menu_title)
    }

    override fun getItemViewType(position: Int): Int {
        return when (menu[position]) {
            is MenuItem.FoodItem -> 0
            is MenuItem.MenuTitle -> 1
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.menu__food_item, parent, false)
                FoodItemViewHolder(view)
            }

            1 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.menu_title_item, parent, false)
                TitleItemViewHolder(view)
            }

            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FoodItemViewHolder -> {
                val currentItem = menu[position] as MenuItem.FoodItem
                holder.ivImage.setImageResource(currentItem.imageID)
                holder.tvName.text = currentItem.name
                holder.tvDescription.text = currentItem.description
                val priceString = "${currentItem.price} kr"
                holder.tvPrice.text = priceString
            }

            is TitleItemViewHolder -> {
                val currentItem = menu[position] as MenuItem.MenuTitle
                holder.tvMenuTitle.text = currentItem.title
            }
        }
    }

    override fun getItemCount(): Int {
        return menu.count()
    }
}