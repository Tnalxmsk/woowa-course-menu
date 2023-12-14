package menu

import menu.extension.toCoachNameTable
import menu.model.Coach
import menu.model.ResultChart
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
        outputView.printServiceEnd(recommendationCategoryWithMenu)
    }

    private fun createCoaches(): List<Coach> {
        val names = inputView.raedCoachName()
        val coaches = names.map { name ->
            val hateMenu = inputView.readHateMenu(name)
            Coach(name, hateMenu)
        }
        return coaches
    }

    private fun startRecommendation(coaches: List<Coach>): ResultChart {
        val recommendationCategory = mutableMapOf<String, String>()
        val recommendationMenus = coaches.toCoachNameTable()

        Week.entries.forEach { week ->
            val category = CategoryRecommender.recommendCategory()
            recommendationCategory[week.title] = category
            coaches.forEach { coach ->
                recommendationMenus[coach.name]!!.add(recommendMenu(category))
            }
        }
        return ResultChart(recommendationCategory, recommendationMenus)
    }

    private fun recommendMenu(category: String): String {
        val menus = Category.getMenus(category)
        val menu = MenuRecommender.recommendMenu(menus)
        return menu
    }
}