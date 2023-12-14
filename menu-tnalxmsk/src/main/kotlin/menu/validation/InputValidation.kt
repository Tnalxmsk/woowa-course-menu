package menu.validation

enum class InputValidation(val message: String) {
    EMPTY_VALUE("[ERROR] 아무 값을 입력하지 않았습니다. 다시 입력해 주세요."),
    INVALID_INPUT_COACH("[ERROR] 코치는 최소 2명 이상 입력해야 합니다."),
    OUT_OF_MAX_COACH("[ERROR] 코치는 최대 4명까지 가능합니다."),
    CONTAIN_GAP("[ERROR] 공백을 포함할 수 없습니다. 다시 입력해 주세요."),
    INVALID_COACH_NAME_LENGTH("[ERROR] 코치 이름은 2글자 이상 4글자 이하입니다.");
    companion object {
        fun validateNames(input: String) {
            val error = when {
                input.isEmpty() -> EMPTY_VALUE
                input.contains(" ") -> CONTAIN_GAP
                input.split(",").size < 2 -> INVALID_INPUT_COACH
                input.split(",").size > 5 -> OUT_OF_MAX_COACH
                input.isInvalidLength() -> INVALID_COACH_NAME_LENGTH
                else -> return
            }
            throw IllegalArgumentException(error.message)
        }


    }
}