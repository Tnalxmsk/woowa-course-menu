package menu

import menu.extension.addMenu
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
        val coachWithMenus = coaches.toCoachNameTable()

        Week.entries.forEach { week ->
            recommendWeekCategory(week, coaches, recommendationCategory, coachWithMenus)
        }
        return ResultChart(recommendationCategory, coachWithMenus)
    }

    private fun recommendWeekCategory(
        week: Week,
        coaches: List<Coach>,
        recommendationCategory: MutableMap<String, String>,
        coachWithMenus: Map<String, MutableList<String>>
    ) {
        while (true) {
            val category = CategoryRecommender.recommendCategory()
            if (recommendationCategory.values.count { it == category } == 2) continue
            recommendationCategory[week.title] = category
            recommendMenu(coaches, category, coachWithMenus)
            break
        }
    }

    private fun recommendMenu(
        coaches: List<Coach>,
        category: String,
        menuTable: Map<String, MutableList<String>>
    ) {
        coaches.addMenu(category, menuTable)
    }
}