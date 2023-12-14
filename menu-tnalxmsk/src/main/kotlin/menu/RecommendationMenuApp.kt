package menu

import menu.model.Coach
import menu.view.InputView
import menu.view.OutputView

class RecommendationMenuApp(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun startRecommendationMenu() {
        outputView.printServiceStart()
        val coaches = createCoaches()
    }

    private fun createCoaches(): List<Coach> {
        val names = inputView.raedCoachName()
        val coaches = names.map { name ->
            val hateMenu = inputView.readHateMenu(name)
            Coach(name, hateMenu)
        }
        return coaches
    }
}