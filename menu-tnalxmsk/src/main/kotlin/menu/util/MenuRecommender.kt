package menu.util

import camp.nextstep.edu.missionutils.Randoms
import menu.model.menu.Menu

object MenuRecommender {
    fun recommendMenu(recommendationMenus: Menu): String {
        val menus = recommendationMenus.getMenus()
        val menu = Randoms.shuffle(menus)[0]
        return menu
    }
}