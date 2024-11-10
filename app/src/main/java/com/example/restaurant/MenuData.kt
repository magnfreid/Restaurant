package com.example.restaurant

val starters =
    listOf(
       MenuItem.MenuTitle("Starters"),
        MenuItem.FoodItem(
            R.drawable.img_starter_shrimps,
            "Shrimps",
            "Spicy shrimps in a glass.",
            109
        ),
        MenuItem.FoodItem(
            R.drawable.img_starter_camembert, "Camembert",
            "Camembert cheese and some chips.",
            79
        ),
        MenuItem.FoodItem(
            R.drawable.img_starter_toast_skagen, "Toast skagen",
            "Shrimp sauce on bread",
            139
        )
)


val mainCourses = listOf(
    MenuItem.MenuTitle("Main courses"),
    MenuItem.FoodItem(
        R.drawable.img_main_tournedos, "Tournedos",
        "The best meat you can get.",
        209
    ),
    MenuItem.FoodItem(
        R.drawable.img_main_cod, "Cod",
        "Fresh fish from the ocean.",
        189
    ),
    MenuItem.FoodItem(
        R.drawable.img_main_hamburger,
        "Hamburger",
        "You can never go wrong with a hamburger.",
        169
    ),
)

val desserts = listOf(
    MenuItem.MenuTitle("Desserts"),
    MenuItem.FoodItem(
        R.drawable.img_dessert_pannacotta,
        "Panna cotta",
        "Classic desert, served with strawberry jam.",
        59
    ),
    MenuItem.FoodItem(
        R.drawable.img_dessert_chocolate,
        "Chocolate",
        "Chocolate in a glass, including berries and cream",
        79
    ),
    MenuItem.FoodItem(
        R.drawable.img_dessert_creme_brulee,
        "Creme brulee",
        "Vanilla pudding with burnt sugar on top.",
        79
    ),
)

fun getAllMenuItems(): List<MenuItem> {
    val allMenuItems = mutableListOf<MenuItem>()
    for (menuItem in starters) {
        allMenuItems.add(menuItem)
    }
    for (menuItem in mainCourses) {
        allMenuItems.add(menuItem)
    }
    for (menuItem in desserts) {
        allMenuItems.add(menuItem)
    }
    return allMenuItems
}
