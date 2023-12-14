package menu.model.menu.food

import menu.model.menu.Menu

enum class KoreanFood(val names: List<String>) : Menu {
    MENU(listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")) {
        override fun getMenus(): List<String> {
            return names
        }
    }
}