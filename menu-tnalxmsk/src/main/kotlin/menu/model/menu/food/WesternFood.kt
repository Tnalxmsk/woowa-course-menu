package menu.model.menu.food

import menu.model.menu.Menu

enum class WesternFood(val names: List<String>) : Menu {
    MENU(listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")) {
        override fun getMenus(): List<String> {
            return names
        }
    }
}