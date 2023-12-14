package menu.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun raedCoachName(): List<String> {
        println(INPUT_COACH_NAME)
        val input = Console.readLine()
        val names = input.split(NAME_SPLIT_DELIMITERS)
        return names
    }

    companion object {
        private const val INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)"
        private const val NAME_SPLIT_DELIMITERS = ","
    }
}