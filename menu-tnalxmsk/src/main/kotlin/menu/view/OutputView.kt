package menu.view

class OutputView {
    fun printServiceStart() = println(OUTPUT_SERVICE_START)

    companion object {
        private const val OUTPUT_SERVICE_START = "점심 메뉴 추천을 시작합니다.\n"
    }
}