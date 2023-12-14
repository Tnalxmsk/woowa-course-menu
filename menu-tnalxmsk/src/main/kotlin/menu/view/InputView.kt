package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.validation.InputValidator

class InputView {
    fun readCoachName(): List<String> {
        try {
            println(INPUT_COACH_NAME)
            val input = Console.readLine()
            InputValidator.validateNames(input)
            println()
            return input.split(SPLIT_DELIMITERS)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return readCoachName()
        }
    }

    fun readHateMenu(name: String): List<String> {
        try {
            println(INPUT_COACH_WORST_MENU.format(name))
            val input = Console.readLine()
            InputValidator.validateHateMenu(input)
            println()
            val menu = input.split(SPLIT_DELIMITERS)
            return menu
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return readHateMenu(name)
        }
    }

    companion object {
        private const val INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)"
        private const val INPUT_COACH_WORST_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요."
        private const val SPLIT_DELIMITERS = ","
    }
}