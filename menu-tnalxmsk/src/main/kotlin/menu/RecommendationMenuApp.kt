package menu

import menu.model.Coach
import menu.model.menu.Category
import menu.model.menu.Week
import menu.util.CategoryRecommender
import menu.util.MenuRecommender
import menu.view.InputView
import menu.view.OutputView

class RecommendationMenuApp(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun startRecommendationMenu() {
        outputView.printServiceStart()
        val coaches = createCoaches()
        val recommendationCategoryWithMenu = startRecommendation(coaches)
    }

    private fun createCoaches(): List<Coach> {
        val names = inputView.raedCoachName()
        val coaches = names.map { name ->
            val hateMenu = inputView.readHateMenu(name)
            Coach(name, hateMenu)
        }
        return coaches
    }

    private fun startRecommendation(coaches: List<Coach>): List<MutableMap<String, out Any>> {
        val recommendationCategory = mutableMapOf<String, String>()
        val recommendationMenus = mutableMapOf<String, Map<String, String>>()
        Week.entries.forEach { week ->
            val category = CategoryRecommender.recommendCategory()
            recommendationCategory[week.title] = category
            recommendationMenus[week.title] = recommendMenu(category, coaches)
        }
        return listOf(recommendationCategory, recommendationMenus)
    }

    private fun recommendMenu(category: String, coaches: List<Coach>): Map<String, String> {
        val coachesMenu = mutableMapOf<String, String>()
        val menus = Category.getMenus(category)
        coaches.forEach { coach ->
            val menu = MenuRecommender.recommendMenu(menus)
            coachesMenu[coach.name] = menu
        }
        return coachesMenu
    }
}