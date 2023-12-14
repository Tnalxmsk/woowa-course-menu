package menu.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun raedCoachName(): List<String> {
        println(INPUT_COACH_NAME)
        val input = Console.readLine()
        val names = input.split(SPLIT_DELIMITERS)
        return names
    }

    fun readHateMenu(name: String): List<String> {
        println(INPUT_COACH_WORST_MENU.format(name))
        val input = Console.readLine()
        println()

        val menu = input.split(SPLIT_DELIMITERS)
        return menu
    }

    companion object {
        private const val INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)"
        private const val INPUT_COACH_WORST_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요."
        private const val SPLIT_DELIMITERS = ","
    }
}