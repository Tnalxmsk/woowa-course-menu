package menu.extension

import menu.model.Coach

fun List<Coach>.toCoachNameTable(): Map<String, MutableList<String>> {
    val recommendationMenus = mutableMapOf<String, MutableList<String>>()
    this.forEach {
        recommendationMenus[it.name] = mutableListOf()
    }
    return recommendationMenus
}

fun List<Coach>.addMenu(menu: String, menuTable: Map<String, MutableList<String>>) {
    this.forEach { coach ->
        menuTable[coach.name]!!.add(menu)
    }
}