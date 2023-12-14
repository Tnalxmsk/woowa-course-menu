package menu.model.menu

import menu.model.menu.food.*

enum class Category(private val categoryNumber: Int, val categoryName: String, val menus: Menu) {
    JAPANESE(1, "일식", JapaneseFood.MENU),
    KOREAN(2, "한식", KoreanFood.MENU),
    CHINESE(3, "중식", ChineseFood.MENU),
    ASIAN(4, "아시안", AsianFood.MENU),
    WESTERN(5, "양식", WesternFood.MENU);

    companion object {
        fun get(categoryNumber: Int): String {
            val category = Category.entries.find {
                it.categoryNumber == categoryNumber
            }
            return category?.categoryName ?: "없음"
        }

        fun getMenus(categoryName: String): Menu {
            val menus = Category.entries.find { it.categoryName == categoryName }
            return menus!!.menus
        }
    }
}