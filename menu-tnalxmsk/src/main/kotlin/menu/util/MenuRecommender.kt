package menu.util

import camp.nextstep.edu.missionutils.Randoms
import menu.model.menu.Menu

object MenuRecommender {
    fun recommendMenu(recommendationMenus: Menu, hateMenus: List<String>, coachMenus: MutableList<String>): String {
        val menus = recommendationMenus.getMenus()
        hateMenus.forEach { menus.remove(it) }
        while (true) {
            val menu = Randoms.shuffle(menus)[0]
            if (coachMenus.contains(menu)) {
                continue
            }
            return menu
        }
    }
}