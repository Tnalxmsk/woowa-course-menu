package menu.model.menu.food

import menu.model.menu.Menu

enum class JapaneseFood(val names: List<String>) : Menu {
    MENU(listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")) {
        override fun getMenus(): MutableList<String> {
            return names.toMutableList()
        }
    }
}