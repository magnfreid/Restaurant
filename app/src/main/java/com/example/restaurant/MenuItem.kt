package com.example.restaurant

sealed class MenuItem {

    data class FoodItem(
        val imageID: Int,
        val name: String,
        val description: String,
        val price: Int
    ) : MenuItem()


    data class MenuTitle(val title: String) : MenuItem()
}