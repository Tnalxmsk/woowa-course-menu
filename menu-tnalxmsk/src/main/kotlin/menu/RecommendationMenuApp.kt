package menu

import menu.view.InputView
import menu.view.OutputView

class RecommendationMenuApp(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun startRecommendationMenu() {
        outputView.printServiceStart()
    }
}