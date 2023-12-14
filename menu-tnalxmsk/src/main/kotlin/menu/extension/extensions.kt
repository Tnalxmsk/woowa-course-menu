package menu.extension

import menu.model.Coach
import menu.model.menu.Category
import menu.util.MenuRecommender

fun List<Coach>.toCoachNameTable(): Map<String, MutableList<String>> {
    val recommendationMenus = mutableMapOf<String, MutableList<String>>()
    this.forEach {
        recommendationMenus[it.name] = mutableListOf()
    }
    return recommendationMenus
}

fun List<Coach>.addMenu(category: String, menuTable: Map<String, MutableList<String>>) {
    this.forEach { coach ->
        val menus = Category.getMenus(category)
        val menu = MenuRecommender.recommendMenu(menus)
        menuTable[coach.name]!!.add(menu)
    }
}

fun <T> Collection<T>.joinPipeString(): String {
    return this.joinToString(" | ");
}