package com.example.restaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView

class MenuAdapter(private val menu: List<MenuItem>) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: MaterialTextView = itemView.findViewById(R.id.tv_menu_item_name)
        val tvDescription: MaterialTextView = itemView.findViewById(R.id.tv_menu_item_description)
        val tvPrice: MaterialTextView = itemView.findViewById(R.id.tv_menu_item_price)
        val ivImage: ImageView = itemView.findViewById(R.id.iv_menu_item_image)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val currentItem = menu[position]
        holder.ivImage.setImageResource(currentItem.imageID)
        holder.tvName.text = currentItem.name
        holder.tvDescription.text = currentItem.description
        val priceString = "${currentItem.price} kr"
        holder.tvPrice.text = priceString
    }

    override fun getItemCount(): Int {
        return menu.count()
    }
}