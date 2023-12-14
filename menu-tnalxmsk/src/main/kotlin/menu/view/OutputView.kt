package menu.view

import menu.model.ResultChart

class OutputView {
    fun printServiceStart() = println(OUTPUT_SERVICE_START)

    fun printServiceEnd(resultChart: ResultChart) {
        println(OUTPUT_MENU_RECOMMENDATION_RESULT)
        printRecommendationServiceDetails(resultChart)
        println()
        println(OUTPUT_SERVICE_END)
    }

    private fun printRecommendationServiceDetails(resultChart: ResultChart, ) {
        val category = resultChart.recommendationCategory
        val menus = resultChart.recommendationMenus
        println(category.keys.joinToString(" | ", "[ ", " ]"))
        println(category.values.joinToString(" | ", "[ ", " ]"))
        menus.forEach {
            println(OUTPUT_DETAILS_FORMAT.format(it.key, it.value.joinToString(" | ")))
        }
    }

    companion object {
        private const val OUTPUT_SERVICE_START = "점심 메뉴 추천을 시작합니다.\n"
        private const val OUTPUT_MENU_RECOMMENDATION_RESULT = "메뉴 추천 결과입니다."
        private const val OUTPUT_SERVICE_END = "추천을 완료했습니다."
        private const val OUTPUT_DETAILS_FORMAT = "[ %s | %s ]"
    }
}