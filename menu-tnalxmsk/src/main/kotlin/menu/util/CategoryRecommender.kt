package menu.util

import camp.nextstep.edu.missionutils.Randoms
import menu.model.menu.Category

object CategoryRecommender {
    fun recommendCategory(): String {
        val categories = Category
        while (true) {
            val category: String = categories.get(Randoms.pickNumberInRange(1, 5))
            if (category != "없음") {
                return category
            }
        }
    }
}