package menu.model.menu.food

import menu.model.menu.Menu

enum class ChineseFood(val names: List<String>) : Menu {
    MENU(listOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")) {
        override fun getMenus(): List<String> {
            return names
        }
    }
}