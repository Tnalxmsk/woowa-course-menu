package menu.util

import camp.nextstep.edu.missionutils.Randoms
import menu.model.menu.Menu

object MenuRecommender {
    fun recommendMenu(recommendationMenus: Menu, hateMenus: List<String>): String {
        val menus = recommendationMenus.getMenus()
        hateMenus.forEach { menus.remove(it) }
        val menu = Randoms.shuffle(menus)[0]
        return menu
    }
}