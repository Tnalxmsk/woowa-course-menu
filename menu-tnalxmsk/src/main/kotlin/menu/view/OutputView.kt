package menu.view

import menu.extension.joinPipeString
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
        println(OUTPUT_WEEK_FORMAT.format(category.keys.joinPipeString()))
        println(OUTPUT_CATEGORY_FORMAT.format(category.values.joinPipeString()))
        menus.forEach {
            println(OUTPUT_DETAILS_FORMAT.format(it.key, it.value.joinPipeString()))
        }
    }

    companion object {
        private const val OUTPUT_SERVICE_START = "점심 메뉴 추천을 시작합니다.\n"
        private const val OUTPUT_MENU_RECOMMENDATION_RESULT = "메뉴 추천 결과입니다."
        private const val OUTPUT_SERVICE_END = "추천을 완료했습니다."
        private const val OUTPUT_WEEK_FORMAT = "[ 구분 | %s ]"
        private const val OUTPUT_CATEGORY_FORMAT = "[ 카테고리 | %s ]"
        private const val OUTPUT_DETAILS_FORMAT = "[ %s | %s ]"
    }
}