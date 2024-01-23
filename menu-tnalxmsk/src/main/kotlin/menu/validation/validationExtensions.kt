package menu.validation

import menu.model.menu.food.*

private const val SPLIT_DELIMITERS = ","

fun String.isInvalidLength(): Boolean {
    this.split(SPLIT_DELIMITERS).forEach {
        if (it.length < 2 || it.length > 4) {
            return true
        }
    }
    return false
}

fun String.isNotContainMenu(): Boolean {
    if (this == "") {
        return false
    }
    this.split(SPLIT_DELIMITERS).forEach {
        if (JapaneseFood.MENU.names.contains(it).not() && KoreanFood.MENU.names.contains(it).not()
            && AsianFood.MENU.names.contains(it).not() && ChineseFood.MENU.names.contains(it).not()
            && WesternFood.MENU.names.contains(it).not()) {
            return true
        }
    }
    return false
}

fun String.isDuplicationName(): Boolean {
    val names = this.split(SPLIT_DELIMITERS)
    return names.size != names.toSet().size
}

fun String.isDuplicationMenu(): Boolean {
    val input = this.split(SPLIT_DELIMITERS)
    if (input.size < 2) {
        return false
    }
    if (input.toSet().size != 2) {
        return true
    }
    return false
}