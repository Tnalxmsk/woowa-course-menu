package menu.model.menu.food

import menu.model.menu.Menu

enum class AsianFood(val names: List<String>) : Menu {
    MENU(listOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")) {
        override fun getMenus(): MutableList<String> {
            return names.toMutableList()
        }
    }
}